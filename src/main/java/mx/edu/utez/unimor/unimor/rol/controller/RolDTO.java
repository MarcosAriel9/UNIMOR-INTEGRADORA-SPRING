package mx.edu.utez.unimor.unimor.rol.controller;

import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.*;

public class RolDTO {
    private long idRol;

    private String rol;

    private Usuario usuario;

    public RolDTO() {
    }

    public RolDTO(long idRol, String rol, Usuario usuario) {
        this.idRol = idRol;
        this.rol = rol;
        this.usuario = usuario;
    }

    public RolDTO(String rol, Usuario usuario) {
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
