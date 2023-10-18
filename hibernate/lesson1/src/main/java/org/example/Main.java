package org.example;

import org.example.profile.Address;
import org.example.profile.Profile;
import org.example.util.EMFSingleton;

public class Main {
    public static void main(String[] args) {
        var emf = EMFSingleton.getEmf();
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        var profile = new Profile();
        profile.setFirstName("Sidr");
        profile.setLastName("Sidorov");
        profile.setAge(28);
        profile.setAddress(new Address()
                .setCity("Penza")
                .setStreet("Pushkina")
                .setBuilding("2"));
        em.persist(profile);
        em.getTransaction().commit();
        em.close();
    }
}