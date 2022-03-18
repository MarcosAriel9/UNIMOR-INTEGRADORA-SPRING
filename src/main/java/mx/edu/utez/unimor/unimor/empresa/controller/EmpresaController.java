package mx.edu.utez.unimor.unimor.empresa.controller;

import mx.edu.utez.unimor.unimor.calificacion.controller.CalificacionDTO;
import mx.edu.utez.unimor.unimor.calificacion.controller.CalificacionService;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/empresa")
@CrossOrigin(origins = {"*"})
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return empresaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.save(new Empresa(empresaDTO.getNombre(),
                empresaDTO.getDescription(), empresaDTO.getTelefono(),empresaDTO.getEstado(), empresaDTO.getUbicacion(), empresaDTO.getCategoria()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.update(new Empresa(empresaDTO.getIdEmpresa(),empresaDTO.getNombre(),
                empresaDTO.getDescription(), empresaDTO.getTelefono(),empresaDTO.getEstado(), empresaDTO.getUbicacion(), empresaDTO.getCategoria()
                ));
    }
}