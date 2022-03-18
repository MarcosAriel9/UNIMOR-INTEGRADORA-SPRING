package mx.edu.utez.unimor.unimor.comentarios.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios,Long> {
    Optional<Comentarios> findByComentarios(String comentarios);
    boolean existsById(long idComentarios);
}
