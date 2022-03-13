package mx.edu.utez.unimor.unimor.categoria.model;

import mx.edu.utez.unimor.unimor.empresa.model.Empresa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;
    @Column(unique = true)
    private String description;
    @ManyToMany(mappedBy = "categoria")
    private List<Empresa> empresas;

    public Categoria() {
    }

    public Categoria(long idCategoria, String description, List<Empresa> empresas) {
        this.idCategoria = idCategoria;
        this.description = description;
        this.empresas = empresas;
    }

    public Categoria(String description, List<Empresa> empresas) {
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
