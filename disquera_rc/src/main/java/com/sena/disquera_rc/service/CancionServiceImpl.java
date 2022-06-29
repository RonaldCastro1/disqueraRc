package com.sena.disquera_rc.service;

import java.util.List;

import com.sena.disquera_rc.model.Cancion;
import com.sena.disquera_rc.model.ListarC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl implements ListarCService{
    @Autowired
    private ListarC cancionz;

    @Override
    public List<Cancion> findAll() {
        
        return (List<Cancion>) cancionz.findAll();
    }

    @Override
    public void save(Cancion cancion) {
       cancionz.save(cancion);        
    }

    @Override
    public Cancion findOne(Integer id_cancion) {
        
        return cancionz.findById(id_cancion).orElse(null);
    }

    @Override
    public void delete(Integer id_cancion) {
        cancionz.deleteById(id_cancion);
        
    }
}
