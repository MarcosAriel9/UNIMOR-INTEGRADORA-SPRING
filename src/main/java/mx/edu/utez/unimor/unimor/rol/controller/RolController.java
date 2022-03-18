package mx.edu.utez.unimor.unimor.rol.controller;

import mx.edu.utez.unimor.unimor.calificacion.controller.CalificacionDTO;
import mx.edu.utez.unimor.unimor.calificacion.controller.CalificacionService;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.rol.model.Rol;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = {"*"})
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return rolService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createRol(@RequestBody RolDTO rolDTO) {
        return rolService.save(new Rol(rolDTO.getRol(), rolDTO.getUsuario()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateRol(@RequestBody RolDTO rolDTO) {
        return rolService.update(new Rol(rolDTO.getIdRol(),rolDTO.getRol(), rolDTO.getUsuario()));
    }
}
