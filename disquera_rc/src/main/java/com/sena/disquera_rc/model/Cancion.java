package com.sena.disquera_rc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="cancion")
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cancion;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_cancion;
    @NotEmpty
    private Integer fecha_grabacion;
    @NotEmpty
    @Column(length=10)
    private Integer duracion;
    @Column(length = 20)
    private Integer id_album;
    private Boolean estado_cancion;
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;
    
    //Constructores
    public Cancion() {
    }

    public Cancion(Integer id_cancion, String nombre_cancion, Integer fecha_grabacion, Integer duracion, Integer id_album, Boolean estado_cancion) {
        this.id_cancion = id_cancion;
        this.nombre_cancion = nombre_cancion;
        this.fecha_grabacion = fecha_grabacion;
        this.duracion = duracion;
        this.id_album = id_album;
        this.estado_cancion = estado_cancion;
        
    }
    //Métodos accesores

    public Integer getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(Integer id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public Integer getFecha_grabacion() {
        return fecha_grabacion;
    }

    public void setFecha_grabacion(Integer fecha_grabacion) {
        this.fecha_grabacion = fecha_grabacion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public Boolean getEstado_cancion() {
        return estado_cancion;
    }

    public void setEstado_cancion(Boolean estado_cancion) {
        this.estado_cancion = estado_cancion;
    }
}
    