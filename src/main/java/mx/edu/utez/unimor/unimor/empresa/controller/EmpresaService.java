package mx.edu.utez.unimor.unimor.empresa.controller;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import mx.edu.utez.unimor.unimor.empresa.model.EmpresaRepository;
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
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                empresaRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (empresaRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, empresaRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró la calificaion",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Empresa empresa){
        Optional<Empresa> existsCategory = empresaRepository.findByEmpresa(empresa.getNombre());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La Empresa ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Empresa savedCategory = empresaRepository.saveAndFlush(empresa);
        return new ResponseEntity<>(new Message("Empresa registrada",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Empresa Empresa){
        if (empresaRepository.existsById(Empresa.getIdEmpresa())){
            return new ResponseEntity<>(new Message("Empresa actualizada",false,
                    empresaRepository.saveAndFlush(Empresa)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Empresa no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}

