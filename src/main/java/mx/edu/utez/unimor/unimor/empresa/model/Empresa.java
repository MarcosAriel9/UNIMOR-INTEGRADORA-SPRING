package mx.edu.utez.unimor.unimor.empresa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.calificacion.model.Calificacion;
import mx.edu.utez.unimor.unimor.categoria.model.Categoria;
import mx.edu.utez.unimor.unimor.comentarios.model.Comentarios;
import mx.edu.utez.unimor.unimor.ubicacion.model.Ubicacion;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpresa;
    @Column(nullable = true)
    private String nombre;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private int telefono;
    @Column(nullable = true)
    private int estado;
    @OneToOne
    @JoinColumn(name = "id_ubicacion",referencedColumnName = "idUbicacion")
    @NotNull
    private Ubicacion ubicacion;
    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Calificacion> calificacion;

    @ManyToMany
    @JoinTable(name = "categoria_has_empresa", joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categoria;

    public Empresa() {
    }

    public Empresa(long idEmpresa, String nombre, String description, int telefono, int estado, Ubicacion ubicacion, List<Categoria> categoria) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.description = description;
        this.telefono = telefono;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }
    public Empresa( String nombre, String description, int telefono, int estado, Ubicacion ubicacion, List<Categoria> categoria) {

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
