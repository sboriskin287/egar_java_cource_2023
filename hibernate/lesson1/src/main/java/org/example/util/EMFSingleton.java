package org.example.util;


import lombok.experimental.UtilityClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@UtilityClass
public class EMFSingleton {

    private EntityManagerFactory emf;

    public synchronized EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Portal");
        }
        return emf;
    }
}
