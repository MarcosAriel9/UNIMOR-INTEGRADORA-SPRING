package mx.edu.utez.unimor.unimor.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.persona.model.Persona;
import mx.edu.utez.unimor.unimor.rol.model.Rol;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(unique = true)
    private String correo;
    @Column(unique = true)
    private String contraseña;
    @Column(unique = true)
    private String foto;
    @OneToOne
    @JoinColumn(nullable=false ,name = "id_rol",referencedColumnName = "idRol")
    @NotNull
    private Rol rol;
    @OneToOne(mappedBy = "usuario")
    private Persona persona;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Calificacion> calificacion;

    public Usuario() {
    }

    public Usuario(long idUsuario, String correo, String contraseña, String foto, Rol rol, Persona persona,List<Calificacion> calificacion) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.foto = foto;
        this.rol = rol;
        this.persona = persona;
        this.calificacion = calificacion;
    }
    public Usuario( String correo, String contraseña, String foto, Rol rol, Persona persona,List<Calificacion> calificacion) {

        this.correo = correo;
        this.contraseña = contraseña;
        this.foto = foto;
        this.rol = rol;
        this.persona = persona;
        this.calificacion = calificacion;
    }


    public List<Calificacion> getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(List<Calificacion> calificacion) {
        this.calificacion = calificacion;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
