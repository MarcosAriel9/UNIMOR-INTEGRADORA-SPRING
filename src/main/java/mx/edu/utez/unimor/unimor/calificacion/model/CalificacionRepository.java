package mx.edu.utez.unimor.unimor.calificacion.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  CalificacionRepository extends JpaRepository<Calificacion,Long> {
    Optional<Calificacion> findBycalificacion(String calificacion);
    boolean existsById(long idCalificacion);
}
