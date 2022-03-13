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
    CategoriaRepository calificacionRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                calificacionRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (calificacionRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, calificacionRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró la calificaion",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Categoria category){
        Optional<Categoria> existsCategory = calificacionRepository.findBycategoria(category.getDescription());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La Categoria ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Categoria savedCategory = calificacionRepository.saveAndFlush(category);
        return new ResponseEntity<>(new Message("Categoria registrada",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Categoria category){
        if (calificacionRepository.existsById(category.getIdCategoria())){
            return new ResponseEntity<>(new Message("Categoria actualizada",false,
                    calificacionRepository.saveAndFlush(category)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Categoria no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}
