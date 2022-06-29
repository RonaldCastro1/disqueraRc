package com.sena.disquera_rc.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlbumDao implements ListarA {
    @PersistenceContext
    private EntityManager al;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)

    @Override
    public List<Album> findAll() {
        return al.createQuery("from Album").getResultList();
    }

    @Override
    @Transactional
    public void save(Album album) {
        if (album.getId_album() !=null && album.getId_album()>0) {
            al.merge(album);
        } else {
            al.persist(album);
        }
        
    }

    @Override
    @Transactional (readOnly=true)
    public Album findOne(Integer id_album) {
        return al.find(Album.class, id_album);
    }

    @Override
    @Transactional
    public void delete(Integer id_album) {
        al.remove(findOne(id_album));
    }


    
}
