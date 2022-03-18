package mx.edu.utez.unimor.unimor.usuario.model;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsuario(String Usuario);
    boolean existsById(long idUsuario);
}