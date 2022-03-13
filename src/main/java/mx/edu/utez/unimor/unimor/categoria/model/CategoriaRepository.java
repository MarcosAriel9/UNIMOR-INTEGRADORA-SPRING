package mx.edu.utez.unimor.unimor.categoria.model;

import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findBycategoria(String categoria);
    boolean existsById(long idCategoria);
}
