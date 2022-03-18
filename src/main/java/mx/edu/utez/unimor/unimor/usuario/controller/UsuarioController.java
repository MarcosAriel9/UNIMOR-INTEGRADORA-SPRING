package mx.edu.utez.unimor.unimor.usuario.controller;


import mx.edu.utez.unimor.unimor.usuario.model.Usuario;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createRol(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(new Usuario(usuarioDTO.getCorreo(), usuarioDTO.getContraseña(), usuarioDTO.getFoto(),
                usuarioDTO.getRol(), usuarioDTO.getPersona(), usuarioDTO.getCalificacion() ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateRol(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(new Usuario(usuarioDTO.getIdUsuario(),usuarioDTO.getCorreo(), usuarioDTO.getContraseña(), usuarioDTO.getFoto(),
                usuarioDTO.getRol(), usuarioDTO.getPersona(), usuarioDTO.getCalificacion() ));
    }
}


