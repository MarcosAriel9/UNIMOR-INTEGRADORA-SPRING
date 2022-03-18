package mx.edu.utez.unimor.unimor.persona.controller;


import mx.edu.utez.unimor.unimor.persona.model.Persona;
import mx.edu.utez.unimor.unimor.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = {"*"})
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createPersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.save(new Persona(personaDTO.getNombre(),
                personaDTO.getApellidoPaterno(), personaDTO.getApellidoMaterno(), personaDTO.getFechaNacimiento(), personaDTO.getUsuario()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updatePersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.update(new Persona(personaDTO.getIdPersona(), personaDTO.getNombre(),
                personaDTO.getApellidoPaterno(), personaDTO.getApellidoMaterno(), personaDTO.getFechaNacimiento(), personaDTO.getUsuario()
        ));
    }
}