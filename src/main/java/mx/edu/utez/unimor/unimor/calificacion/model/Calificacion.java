package mx.edu.utez.unimor.unimor.calificacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.*;


@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCalificacion;
    @Column(columnDefinition = "text",unique = true)
    private String calificacion;
    @Column(columnDefinition = "text",unique = true)
    private String favoritos;
    @ManyToOne
    @JoinColumn(name = "Usuario")
    @NotNull
    private Usuario usuario;
    @OneToMany(mappedBy = "calificaion")
    @JsonIgnore
    private List<Subcategory> subcategories;
}
