package com.sena.disquera_rc.model;

import java.util.List;

public interface ListarA {
    public List <Album> findAll();
    public void save (Album album);
    public Album findOne(Integer id_album);
    public void delete(Integer id_album);
}