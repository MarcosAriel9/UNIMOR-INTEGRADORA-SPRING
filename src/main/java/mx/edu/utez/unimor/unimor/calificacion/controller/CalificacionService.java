package mx.edu.utez.unimor.unimor.calificacion.controller;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.calificacion.model.CalificacionRepository;
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
public class CalificacionService {
    @Autowired
    CalificacionRepository calificacionRepository;

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
    public ResponseEntity<Message> save(Calificacion calificacion){
        Optional<Calificacion> existsCategory = calificacionRepository.findBycalificacion(calificacion.getCalificacion());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La calificaion ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Calificacion savedCategory = calificacionRepository.saveAndFlush(calificacion);
        return new ResponseEntity<>(new Message("calificaion registrada",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Calificacion calificacion){
        if (calificacionRepository.existsById(calificacion.getIdCalificacion())){
            return new ResponseEntity<>(new Message("calificaion actualizada",false,
                    calificacionRepository.saveAndFlush(calificacion)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La calificaion no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}

