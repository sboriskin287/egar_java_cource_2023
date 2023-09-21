package ru.egar.v1;

public class RoundRobin {

    void spin() {
        System.out.println("Поехали!!!!");
    }

    public void spin(float rate) {
        this.spin();
        System.out.printf("Я вращаюсь со скоростью %f\n", rate);
    }

}
