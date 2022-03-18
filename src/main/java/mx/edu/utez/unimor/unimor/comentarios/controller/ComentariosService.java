package mx.edu.utez.unimor.unimor.comentarios.controller;

import mx.edu.utez.unimor.unimor.comentarios.model.Comentarios;
import mx.edu.utez.unimor.unimor.comentarios.model.ComentariosRepository;
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
public class ComentariosService {
    @Autowired
    ComentariosRepository comentariosRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                comentariosRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (comentariosRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, comentariosRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró Comentarios",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Comentarios comentarios){
        Optional<Comentarios> existscomentarios = comentariosRepository.findByComentario(comentarios.getComentario());
        if (existscomentarios.isPresent()){
            return new ResponseEntity<>(new Message("LOS comentarios ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Comentarios savedComentarios = comentariosRepository.saveAndFlush(comentarios);
        return new ResponseEntity<>(new Message("comentario registrada",false,savedComentarios),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Comentarios comentarios){
        if (comentariosRepository.existsById(comentarios.getIdComentarios())){
            return new ResponseEntity<>(new Message("comentarios actualizados",false,
                    comentariosRepository.saveAndFlush(comentarios)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La calificaion no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}
