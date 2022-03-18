package mx.edu.utez.unimor.unimor.calificacion.controller;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificacion")
@CrossOrigin(origins = {"*"})
public class CalificacionController {
    @Autowired
    CalificacionService calificacionService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return calificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return calificacionService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.save(new Calificacion(calificacionDTO.getCalificacion(),calificacionDTO.getFavoritos(),
                calificacionDTO.getComentarios(),calificacionDTO.getEmpresa(),calificacionDTO.getUsuario()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCalificacion(@RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.update(new Calificacion(calificacionDTO.getIdCalificacion(),
                calificacionDTO.getCalificacion(),calificacionDTO.getFavoritos(),
                calificacionDTO.getComentarios(),calificacionDTO.getEmpresa(),calificacionDTO.getUsuario()));
    }
}

