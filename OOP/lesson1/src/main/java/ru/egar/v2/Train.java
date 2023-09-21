package ru.egar.v2;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

public class Train implements Attraction {

    @Override
    public LocalDateTime start() {
        System.out.println("Чух чух, я СМОГУ!!!");
        return now();
    }

    @Override
    public LocalDateTime finish() {
        System.out.println("Чух чух, я СМОГ!!!");
        return now();
    }
}
