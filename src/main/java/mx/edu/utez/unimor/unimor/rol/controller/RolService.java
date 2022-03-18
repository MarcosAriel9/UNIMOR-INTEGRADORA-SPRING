package mx.edu.utez.unimor.unimor.rol.controller;

import mx.edu.utez.unimor.unimor.rol.model.Rol;
import mx.edu.utez.unimor.unimor.rol.model.RolRepository;
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
public class RolService {
    @Autowired
RolRepository rolRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                rolRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (rolRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, rolRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró el Rol",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Rol rol){
        Optional<Rol> existsCategory = rolRepository.findByRol(rol.getRol());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("El Rol ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Rol savedCategory = rolRepository.saveAndFlush(rol);
        return new ResponseEntity<>(new Message("Rol registrado",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Rol rol){
        if (rolRepository.existsById(rol.getIdRol())){
            return new ResponseEntity<>(new Message("Rol actualizado",false,
                    rolRepository.saveAndFlush(rol)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Rol no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}
