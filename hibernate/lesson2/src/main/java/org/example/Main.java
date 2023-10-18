package org.example;

import org.example.profile.ProfileDao;
import org.example.profile.dto.ProfileCriteria;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var pDao = new ProfileDao();
        var profileOpt = pDao.findById(5);
        profileOpt.ifPresent(System.out::println);

        var profiles1 = pDao.findByCriteriaWithQuery(
                new ProfileCriteria().setFirstNames(List.of("Vodkin", "Denis")));
        profiles1.forEach(System.out::println);
        System.out.println();

        var profile2 = pDao.findByCriteriaWithNamedQuery(new ProfileCriteria()
                .setFirstNames(List.of("Sidr", "Denis")));
        profile2.forEach(System.out::println);
        System.out.println();

        var profiles3 = pDao.findByCriteria(new ProfileCriteria()
                .setLastName("Vodkin"));
        profiles3.forEach(System.out::println);
    }
}