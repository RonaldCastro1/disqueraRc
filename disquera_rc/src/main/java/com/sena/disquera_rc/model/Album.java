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
@Table(name="albumes")
public class Album {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_album;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_album;
    private Integer ano_publicacion;
    private Integer id_artista;
    private Integer id_genero;
    private Boolean estado_album;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album",  cascade = CascadeType.ALL)
    private List<Cancion> cancion;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;
    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

//Constructor
public Album(){
    cancion=new ArrayList<Cancion>();
}
public Album(Integer id_album, String nombre_album, Integer ano_publicacion, Integer id_artista, Integer id_genero, boolean estado_album){
    this.id_album=id_album;
    this.nombre_album=nombre_album;
    this.ano_publicacion=ano_publicacion;
    this.id_artista=id_artista;
    this.id_genero=id_genero;
    this.estado_album=estado_album;
}
//Metodos
public Integer getId_album() {
    return id_album;
}
public void setId_album(Integer id_album) {
    this.id_album = id_album;
}
public String getNombre_album() {
    return nombre_album;
}
public void setNombre_album(String nombre_album) {
    this.nombre_album = nombre_album;
}
public Integer getAno_publicacion() {
    return ano_publicacion;
}
public void setAno_publicacion(Integer ano_publicacion) {
    this.ano_publicacion = ano_publicacion;
}
public Integer gerId_artista(){
    return id_artista;
}
public void setId_artista(Integer id_artista){
    this.id_artista=id_artista;
}
public Integer getId_genero() {
    return id_genero;
}
public void setId_genero(Integer id_genero) {
    this.id_genero = id_genero;
}
public Boolean getEstado_album() {
    return estado_album;
}
public void setEstado_album(Boolean estado_album) {
    this.estado_album = estado_album;
}

}
