package mx.edu.utez.unimor.unimor.calificacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.comentarios.model.Comentarios;
import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.*;
import java.util.List;


@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCalificacion;
    @Column(unique = true)
    private String calificacion;
    @Column(unique = true)
    private String favoritos;
    @OneToMany(mappedBy = "calificacion")
    @JsonIgnore
    private List<Comentarios> comentarios;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @NotNull
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull
    private Usuario usuario;


}
