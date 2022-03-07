package mx.edu.utez.unimor.unimor.comentarios.model;

import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;

import javax.persistence.*;

@Entity
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComentarios;
    @Column(unique = true)
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_calificacion")
    @NotNull
    private Calificacion calificacion;

}
