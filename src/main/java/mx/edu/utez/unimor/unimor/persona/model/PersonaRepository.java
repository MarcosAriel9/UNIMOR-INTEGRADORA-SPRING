package mx.edu.utez.unimor.unimor.persona.model;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByNombre(String Persona);
    boolean existsById(long idPersona);
}