package mx.edu.utez.unimor.unimor.empresa.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.categoria.model.Categoria;
import mx.edu.utez.unimor.unimor.ubicacion.model.Ubicacion;

import javax.persistence.*;
import java.util.List;

public class EmpresaDTO {

    private long idEmpresa;
    private String nombre;
    private String description;
    private int telefono;
    private int estado;
    private Ubicacion ubicacion;
    private List<Calificacion> calificacion;

    @ManyToMany
    @JoinTable(name = "categoria_has_empresa", joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categoria;

    public EmpresaDTO() {
    }

    public EmpresaDTO(long idEmpresa, String nombre, String description, int telefono, int estado, Ubicacion ubicacion, List<Categoria> categoria) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.description = description;
        this.telefono = telefono;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }
    public EmpresaDTO( String nombre, String description, int telefono, int estado, Ubicacion ubicacion, List<Categoria> categoria) {

        this.nombre = nombre;
        this.description = description;
        this.telefono = telefono;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}


