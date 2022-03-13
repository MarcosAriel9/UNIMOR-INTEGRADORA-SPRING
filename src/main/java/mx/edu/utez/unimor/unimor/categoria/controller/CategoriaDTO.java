package mx.edu.utez.unimor.unimor.categoria.controller;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;

public class CategoriaDTO {
    private long idCategoria;
    private String description;
    private List<Empresa> empresas;
    public CategoriaDTO() {
    }

    public CategoriaDTO(long idCategoria, String description, List<Empresa> empresas) {
        this.idCategoria = idCategoria;
        this.description = description;
        this.empresas = empresas;
    }

    public CategoriaDTO(String description, List<Empresa> empresas) {
        this.description = description;
        this.empresas = empresas;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}


