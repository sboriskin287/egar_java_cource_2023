package org.example;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.example.RainbowColor.BLUE;
import static org.example.RainbowColor.CYAN;
import static org.example.RainbowColor.GREEN;
import static org.example.RainbowColor.MAGENTA;
import static org.example.RainbowColor.RED;
import static org.example.RainbowColor.RESET;
import static org.example.RainbowColor.YELLOW;


public class Main {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        var colors = List.of(RED, RED, YELLOW, GREEN, CYAN, BLUE, MAGENTA);
        var strings = List.of("Каждый ", "охотник ", "желает ", "знать ", "где ", "сидит ", "фазан\n");
        System.out.println("Rainbow with countdown latch!");
        var cdlList = Stream.concat(Stream.of(new CountDownLatch(0)), Stream.generate(() -> new CountDownLatch(1)).limit(7)).toList();
        IntStream.range(0, 7).mapToObj(i -> new Thread(new RainbowCDL(colors.get(i) + strings.get(i) + RESET, cdlList.get(i), cdlList.get(i + 1)))).forEach(Thread::start);
        cdlList.get(7).await();

        System.out.println("Rainbow with cycle barrier!");
        var cblList = Stream.generate(() -> new CyclicBarrier(2)).limit(8).toList();
        IntStream.range(0, 7).mapToObj(i -> {
            CyclicBarrier curr = cblList.get(i);
            CyclicBarrier next = i < 6 ? cblList.get(i + 1) : cblList.get(0);
            CyclicBarrier finall = i == 6 ? cblList.get(7) : null;
            return new Thread(new RainbowCB(colors.get(i) + strings.get(i) + RESET, curr, next, finall));
        }).forEach(Thread::start);
        cblList.get(0).await();
        cblList.get(7).await();


        var list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        list
                .stream()
                .skip(2)
                .limit(6)
                .filter(i -> (i % 2) == 0)
                .map(i -> i * 2)
                .peek(System.out::println)
                .forEach(System.out::println);

        var originD = new Department();
        originD.setName("Over code");
        originD.setAddress("Puskina 2");
        originD.setPostCode("440000");
        originD.setPopulation(30);
        originD.setActive(true);
        var copyD = Copier.copy(originD);
        System.out.println(originD);
        System.out.println(copyD);
        System.out.printf("It's same instances: %b\n", originD == copyD);
    }

    public static class Department {
        private String name;
        private String address;
        private String postCode;
        @Max(value = 30)
        private Integer population;
        private Boolean isActive;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

        public Boolean getActive() {
            return isActive;
        }

        public void setActive(Boolean active) {
            isActive = active;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", postCode='" + postCode + '\'' +
                    ", population=" + population +
                    ", isActive=" + isActive +
                    '}';
        }
    }
}