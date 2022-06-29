package com.sena.disquera_rc.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeneroDao implements ListarG {
    @PersistenceContext
    private EntityManager ge;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)

    @Override
    public List<Genero> findAll() {
        return ge.createQuery("from Genero").getResultList();
    }

    @Override
    @Transactional
    public void save(Genero genero) {
        if (genero.getId_genero() !=null && genero.getId_genero()>0) {
            ge.merge(genero);
        } else {
            ge.persist(genero);
        }
        
    }

    @Override
    @Transactional (readOnly=true)
    public Genero findOne(Integer id_genero) {
        return ge.find(Genero.class, id_genero);
    }

    @Override
    @Transactional
    public void delete(Integer id_genero) {
        ge.remove(findOne(id_genero));
    }

    
}
