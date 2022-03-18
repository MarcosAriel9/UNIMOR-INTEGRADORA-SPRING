package mx.edu.utez.unimor.unimor.categoria.controller;


import mx.edu.utez.unimor.unimor.categoria.model.Categoria;
import mx.edu.utez.unimor.unimor.categoria.model.CategoriaRepository;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                categoriaRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (categoriaRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, categoriaRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró la calificaion",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Categoria category){
        Optional<Categoria> existsCategory = categoriaRepository.findByDescription(category.getDescription());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La Categoria ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Categoria savedCategory = categoriaRepository.saveAndFlush(category);
        return new ResponseEntity<>(new Message("Categoria registrada",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Categoria category){
        if (categoriaRepository.existsById(category.getIdCategoria())){
            return new ResponseEntity<>(new Message("Categoria actualizada",false,
                    categoriaRepository.saveAndFlush(category)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Categoria no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}
