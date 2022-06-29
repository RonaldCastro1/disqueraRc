package com.sena.disquera_rc.service;

import java.util.List;

import com.sena.disquera_rc.model.Cancion;

public interface ListarCService {
    public List <Cancion> findAll();
    public void save (Cancion cancion);
    public Cancion findOne(Integer id_cancion);
    public void delete(Integer id_cancion);
}
