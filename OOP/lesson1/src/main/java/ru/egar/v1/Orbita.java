package ru.egar.v1;

public class Orbita extends RoundRobin {

    private final long angle;

    public Orbita(long angle) {
        this.angle = angle;
    }

    @Override
    void spin() {
        super.spin();
        System.out.printf("Лечу на орбите под углом %03d\n", angle);
    }
}
