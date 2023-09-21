package ru.egar.v2;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

public class Horses implements Attraction {

    @Override
    public LocalDateTime start() {
        System.out.println("Лошадки поехали");
        return now();
    }

    @Override
    public LocalDateTime finish() {
        System.out.println("Лошадки приехали");
        return now();
    }
}
