package mx.edu.utez.unimor.unimor.calificacion.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.comentarios.model.Comentarios;
import mx.edu.utez.unimor.unimor.empresa.model.Empresa;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class CalificacionDTO {

    private long idCalificacion;

    private String calificacion;

    private String favoritos;

    private List<Comentarios> comentarios;
    @NotNull
    private Empresa empresa;
    @NotNull
    private Usuario usuario;

    public CalificacionDTO() {
    }

    public CalificacionDTO(String calificacion, String favoritos, List<Comentarios> comentarios, Empresa empresa, Usuario usuario) {
        this.calificacion = calificacion;
        this.favoritos = favoritos;
        this.comentarios = comentarios;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public CalificacionDTO(long idCalificacion, String calificacion, String favoritos, List<Comentarios> comentarios, Empresa empresa, Usuario usuario) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;
        this.favoritos = favoritos;
        this.comentarios = comentarios;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
