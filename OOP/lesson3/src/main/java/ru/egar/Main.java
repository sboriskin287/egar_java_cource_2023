package ru.egar;

import ru.egar.profile.Profile;
import ru.egar.profile.TestRecursion;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Profile p = new Profile(LocalDate.parse("2023-09-22"));
//        double workMinutes = p.calcExp();
//        System.out.println(workMinutes);
//        System.out.printf("%.16f\n", p.calc01and02f());
//        System.out.printf("%.32f\n", p.calc01and02d());
//        System.out.printf("%d\n", (int) p.showChar());
//        p.add();

        TestRecursion tr = new TestRecursion();
        System.out.println(tr.fact(6));
        System.out.println(tr.fibb(8));
    }
}