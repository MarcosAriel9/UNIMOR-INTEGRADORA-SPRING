package mx.edu.utez.unimor.unimor.comentarios.controller;


import mx.edu.utez.unimor.unimor.comentarios.model.Comentarios;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = {"*"})
public class ComentariosController {
    @Autowired
    ComentariosService comentariosService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return comentariosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return comentariosService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createCategory(@RequestBody ComentariosDTO comentariosDTO) {
        return comentariosService.save(new Comentarios(comentariosDTO.getComentario(),comentariosDTO.getCalificacion()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody ComentariosDTO comentariosDTO) {
        return comentariosService.update(new Comentarios(comentariosDTO.getIdComentarios(), comentariosDTO.getComentario(),comentariosDTO.getCalificacion()));
    }
}
