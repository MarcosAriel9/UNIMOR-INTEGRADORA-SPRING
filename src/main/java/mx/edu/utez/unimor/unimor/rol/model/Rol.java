package mx.edu.utez.unimor.unimor.rol.model;

import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.persona.model.Persona;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRol;
    @Column(unique = true)
    private String rol;
    @OneToOne(mappedBy = "rol")
    private Usuario usuario;
}
