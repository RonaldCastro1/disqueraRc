package com.sena.disquera_rc.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="disquera")
public class Disquera {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_disquera;
    @NotEmpty
    @Column
    private String nit_disquera;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_disquera;
    @NotEmpty
    @Column
    private String telefono_disquera;
    @NotEmpty
    @Column
    private String direccion_disquera;
    @NotEmpty
    @Column
    private Boolean estado_disquera;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disquera",  cascade = CascadeType.ALL)
    private List<Artista> artista;

    public Disquera(){
        artista=new ArrayList<Artista>();
    }

    public Integer getId_disquera() {
        return id_disquera;
    }

    public void setId_disquera(Integer id_disquera) {
        this.id_disquera = id_disquera;
    }

    public String getNit_disquera() {
        return nit_disquera;
    }

    public void setNit_disquera(String nit_disquera) {
        this.nit_disquera = nit_disquera;
    }

    public String getNombre_disquera() {
        return nombre_disquera;
    }

    public void setNombre_disquera(String nombre_disquera) {
        this.nombre_disquera = nombre_disquera;
    }

    public String getTelefono_disquera() {
        return telefono_disquera;
    }

    public void setTelefono_disquera(String telefono_disquera) {
        this.telefono_disquera = telefono_disquera;
    }

    public String getDireccion_disquera() {
        return direccion_disquera;
    }

    public void setDireccion_disquera(String direccion_disquera) {
        this.direccion_disquera = direccion_disquera;
    }

    public Boolean getEstado_disquera() {
        return estado_disquera;
    }

    public void setEstado_disquera(Boolean estado_disquera) {
        this.estado_disquera = estado_disquera;
    }

    public List<Artista> getArtista() {
        return artista;
    }

    public void setArtista(List<Artista> artista) {
        this.artista = artista;
    }

}