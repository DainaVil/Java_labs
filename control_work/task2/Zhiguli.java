package task2;

import java.util.Random;

public class Zhiguli extends Car {

    private boolean isStartable;
    Random random = new Random();

    public Zhiguli(String color, int maxSpeed, String gearbox, int price) {
        super(color, maxSpeed, gearbox, price);
    }

    @Override
    public void start() {
        this.isStartable =  random.nextBoolean();
        if (this.isStartable) {
            this.setCurrentSpeed(1);
        } else {
            System.out.println("Машина не заводится");
        }
    }

    @Override
    public void accelerate(int speed) {
        if (this.isStartable) {
            super.accelerate(speed);
        } else {
            System.out.println("Машина не заводится");
        }
    }

    public void repair() {
        this.isStartable = true;
        System.out.println("Машина отремонтирована");
    }
}
