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
    @JoinColumn(nullable=false,name = "id_calificacion")
    @NotNull
    private Calificacion calificacion;

    public Comentarios() {
    }

    public Comentarios(long idComentarios, String comentario, Calificacion calificacion) {
        this.idComentarios = idComentarios;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Comentarios(String comentario, Calificacion calificacion) {
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public long getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(long idComentarios) {
        this.idComentarios = idComentarios;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
}
