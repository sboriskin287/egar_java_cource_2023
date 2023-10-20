package org.example.profile.entity;

import org.example.util.EMFSingleton;

import javax.persistence.EntityManagerFactory;

public class ShowRoomDao {
    private final EntityManagerFactory emf;

    public ShowRoomDao() {
        this.emf = EMFSingleton.getEmf();
    }

    public Showroom findById(Integer id) {
        var em = emf.createEntityManager();
        return em.find(Showroom.class, id);
    }
}
