package ru.egar.profile;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.between;

public class Profile {

    private final LocalDate startWork;

    public Profile(LocalDate startWork) {
        this.startWork = startWork;
    }

    public float calcExp() {
        long expSeconds = between(
                LocalDateTime.of(startWork, LocalTime.MIDNIGHT),
                LocalDateTime.now()).toSeconds();
        return expSeconds / 60;
    }

    public float calc01and02f() {
        return 0.1f + 0.2f;
    }

    public double calc01and02d() {
        return 0.1 + 0.2;
    }

    public short showByte() {
        return 5999;
    }

    public char showChar() {
        return 'a';
    }

    public boolean showString() {
        Integer int1 = 10;
        Integer int2 = 10;
        return int1 == int2;
    }

    public int bitAnd() {
        int n1 = 2;
        int n2 = 1;
        return n1 & n2;
    }

    public Float numOrNull() {
        boolean b1 = Math.random() < 0.5;
        if (b1) {
            return 0.5F;
        } else {
            return null;
        }
    }

    public void add() {
        String[] strArr = {"str1", "str2", "str3", "str4", "str5"};
        for (int i = 0; i < strArr.length; i += 1) {
            if (i == 2) {
                break;
            }
            System.out.println("index: " + i + " " + strArr[i]);
        }
        for (String str : strArr) {
            if (str == "str2") {
                return;
            }
            System.out.println(str);
        }
        int i = 0;
        while (i < strArr.length) {
            System.out.println("index: " + i + " " + strArr[i]);
            i += 1;
        }
        int j = 7;
        switch (j) {
            case 1:
                System.out.println("Один");
            case 2:
                System.out.println("Два");
                break;
            default:
                System.out.println("Что то еще");
                return;
        }
    }

}
