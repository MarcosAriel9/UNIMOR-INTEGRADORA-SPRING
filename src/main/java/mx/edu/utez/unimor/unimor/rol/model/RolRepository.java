package mx.edu.utez.unimor.unimor.rol.model;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByRol(String Rol);
    boolean existsById(long idRol);
}