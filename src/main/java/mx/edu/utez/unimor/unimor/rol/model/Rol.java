package mx.edu.utez.unimor.unimor.rol.model;


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

    public Rol() {
    }

    public Rol(long idRol, String rol, Usuario usuario) {
        this.idRol = idRol;
        this.rol = rol;
        this.usuario = usuario;
    }

    public Rol(String rol, Usuario usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
