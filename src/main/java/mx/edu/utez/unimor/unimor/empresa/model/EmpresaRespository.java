package mx.edu.utez.unimor.unimor.empresa.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRespository extends JpaRepository<Empresa,Long> {
        Optional<Empresa> findByEmpresa(String Empresa);
        boolean existsById(long idEmpresa);
        }