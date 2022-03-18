package mx.edu.utez.unimor.unimor.persona.controller;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import mx.edu.utez.unimor.unimor.persona.model.Persona;
import mx.edu.utez.unimor.unimor.persona.model.PersonaRepository;
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
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Transactional
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("ok", false,
                personaRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id) {
        if (personaRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("ok",
                    false, personaRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se encontró la Persona", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> save(Persona persona) {
        Optional<Persona> existsPersona = personaRepository.findByPersona(persona.getNombre());
        if (existsPersona.isPresent()) {
            return new ResponseEntity<>(new Message("La Persona ya existe", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        Persona savedPersona = personaRepository.saveAndFlush(persona);
        return new ResponseEntity<>(new Message("Persona registrada", false, savedPersona),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Persona persona) {
        if (personaRepository.existsById(persona.getIdPersona())) {
            return new ResponseEntity<>(new Message("Persona actualizada", false,
                    personaRepository.saveAndFlush(persona)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Empresa no existe", true, null),
                HttpStatus.BAD_REQUEST);
    }
}