package ru.egar.profile;

public class TestRecursion {

    public int fact(int i) {
        if (i == 1) {
            return 1;
        }
        return fact(i - 1) * i;
    }

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibb(int i) {
        if (i <= 2) {
            return i;
        }
        var res = fibb(i - 1) + fibb(i - 2);
        System.out.print(res + " ");
        return res;
    }

}
