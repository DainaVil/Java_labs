package task2;

public class Main {
    public static void main(String[] args) {
        var car1 = new Zhiguli("purple", 70, "mechanic", 60000);
        var car2 = new Zhiguli("black", 70, "mechanic", 50000);
        var car3 = new Ferrari("red", 600, "mechanic", 1_000_000_000, 2017);

        System.out.println("Заводим жигули (могут не завестись)");
        car1.start();
        car1.accelerate(100);
        car1.stop();
       System.out.println(car1.getCurrentSpeed());

        var garage1 = new Garage(1);
        var garage2 = new Garage(3);

        System.out.println("-------");
        System.out.println("Добавляем машины в гараж 1\n");

        garage1.addCar(car1);
        garage1.addCar(car2); // не поместится

        System.out.println("-------");
        System.out.println("Добавляем машины в гараж 2\n"); 

        garage2.addCar(car3);
        garage2.addCar(car1);
        garage2.addCar(car1); //две одинаковые машины для проверки суммирования

        garage2.printCars();


    }
}
