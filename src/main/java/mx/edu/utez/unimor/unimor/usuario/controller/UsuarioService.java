package mx.edu.utez.unimor.unimor.usuario.controller;


import mx.edu.utez.unimor.unimor.rol.model.RolRepository;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;
import mx.edu.utez.unimor.unimor.usuario.model.UsuarioRepository;
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
public class UsuarioService {
    @Autowired
UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok",false,
                usuarioRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id){
        if (usuarioRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",
                    false, usuarioRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró el Rol",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Usuario usuario){
        Optional<Usuario> existsCategory = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("El usuario ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Usuario savedCategory = usuarioRepository.saveAndFlush(usuario);
        return new ResponseEntity<>(new Message("usuario registrado",false,savedCategory),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Usuario usuario){
        if (usuarioRepository.existsById(usuario.getIdUsuario())){
            return new ResponseEntity<>(new Message("usuario actualizado",false,
                    usuarioRepository.saveAndFlush(usuario)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("usuario no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }
}
