package ru.egartech;

import java.util.Random;

public class PortalPrototypeBean {
    private final Integer course;

    public PortalPrototypeBean() {
        this.course = new Random().nextInt(100);
    }

    public Integer getCurrencyCource() {
        return course;
    }

}
