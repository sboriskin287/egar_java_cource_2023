package org.example;

import org.example.profile.ProfileDao;
import org.example.profile.dto.TaskDto;
import org.example.profile.entity.Task;
import org.example.profile.entity.TaskDao;

public class Main {

    static int i = 5;
    int j = 7;

    public Main() {
        System.out.println();
    }

    public void test() {
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {

        System.out.println(i);
        System.out.println(new Main().j);
    }
}