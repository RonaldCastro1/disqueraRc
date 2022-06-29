package com.sena.disquera_rc.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="artista")
public class Artista {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_artista;
    @NotEmpty
    @Column
    private String no_documento;
    @NotEmpty
    @Column
    private String tipo_documento;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_artista;
    @NotEmpty
    @Column
    private String apellido_artista;
    @NotEmpty
    @Column
    private Integer nombre_artistico;
    @NotEmpty
    @Column
    private String email_artista;
    @NotEmpty
    @Column
    private Integer id_disquera;
    @NotEmpty
    @Column
    private Boolean estado_album;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artista",  cascade = CascadeType.ALL)
    private List<Album> album;
    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;

    public Artista(){
        album=new ArrayList<Album>();
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }

    public String getNo_documento() {
        return no_documento;
    }

    public void setNo_documento(String no_documento) {
        this.no_documento = no_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getApellido_artista() {
        return apellido_artista;
    }

    public void setApellido_artista(String apellido_artista) {
        this.apellido_artista = apellido_artista;
    }

    public Integer getNombre_artistico() {
        return nombre_artistico;
    }

    public void setNombre_artistico(Integer nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }

    public String getEmail_artista() {
        return email_artista;
    }

    public void setEmail_artista(String email_artista) {
        this.email_artista = email_artista;
    }

    public Integer getId_disquera() {
        return id_disquera;
    }

    public void setId_disquera(Integer id_disquera) {
        this.id_disquera = id_disquera;
    }

    public Boolean getEstado_album() {
        return estado_album;
    }

    public void setEstado_album(Boolean estado_album) {
        this.estado_album = estado_album;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }
}

