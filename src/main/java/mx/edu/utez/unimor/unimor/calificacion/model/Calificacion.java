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

    public Calificacion() {
    }

    public Calificacion(String calificacion, String favoritos, List<Comentarios> comentarios, Empresa empresa, Usuario usuario) {
        this.calificacion = calificacion;
        this.favoritos = favoritos;
        this.comentarios = comentarios;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public Calificacion(long idCalificacion, String calificacion, String favoritos, List<Comentarios> comentarios, Empresa empresa, Usuario usuario) {
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
