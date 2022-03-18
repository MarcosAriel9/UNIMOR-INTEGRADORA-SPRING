package mx.edu.utez.unimor.unimor.comentarios.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;



public class ComentariosDTO {

    private long idComentarios;

    private String comentario;

    @NotNull
    private Calificacion calificacion;

    public ComentariosDTO() {
    }

    public ComentariosDTO(long idComentarios, String comentario, Calificacion calificacion) {
        this.idComentarios = idComentarios;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public ComentariosDTO(String comentario, Calificacion calificacion) {
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
