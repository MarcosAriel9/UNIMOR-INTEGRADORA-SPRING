package mx.edu.utez.unimor.unimor.persona.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.unimor.unimor.ubicacion.model.Ubicacion;
import mx.edu.utez.unimor.unimor.usuario.model.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String apellidoPaterno;



    @Column(unique = true)
    private String apellidoMaterno;
    @Column(columnDefinition = "date",unique = true)
    private String fechaNacimiento;

    @OneToOne
    @JoinColumn(name = "id_usuario",referencedColumnName = "idUsuario")
    @NotNull
    private Usuario usuario;

    public Persona() {
    }

    public Persona(long idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, Usuario usuario) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
    }
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, Usuario usuario) {

        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
    }


    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
