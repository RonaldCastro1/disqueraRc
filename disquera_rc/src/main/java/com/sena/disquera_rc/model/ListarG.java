package com.sena.disquera_rc.model;

import java.util.List;

public interface ListarG {
    public List <Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer id_genero);
    public void delete(Integer id_genero);
}