package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private int carPlaces;
    private int allCars;
    private HashMap<Car, Integer> cars; 

    public Garage(int carPlaces) {
        this.carPlaces = carPlaces;
        this.cars = new HashMap<Car, Integer>();
    }

    public int getAllCars() {
        setAllCars(allCars);
        return allCars;
    }

    public void setAllCars(int allCars) {
        this.allCars = cars.size();
    }

    public int addCar(Car car) {
        if (getAllCars() < this.carPlaces) {
            if (cars.get(car) != null){ 
                this.cars.put(car, cars.get(car) + 1);
            } else {
                this.cars.put(car, 1);
            }
            
            System.out.println("Машина добавлена");
        } else {
            System.out.println("Больше машин не поместится");
        }
        return cars.size();
    }

    public void printCars(boolean byPrice) {
        System.out.println("\nМашины в гараже");

        ArrayList<Map.Entry<Car, Integer>> entries = new ArrayList<>(this.cars.entrySet());
        
        if (!(byPrice)) {
            entries.sort((o2, o1) -> Integer.compare(o1.getValue(), o2.getValue()));  
            System.out.println("Машина / Кол-во");
            for(Map.Entry<Car, Integer> entry : entries) {
                System.out.println(entry.getKey() + " / " + entry.getValue());
            }
        } else {
            // сортировка по цене
            entries.sort((o2, o1) -> Integer.compare(o1.getKey().getPrice(), o2.getKey().getPrice()));  
            System.out.println("Машина / Ценa");
            for(Map.Entry<Car, Integer> entry : entries) {
                System.out.println(entry.getKey() + " / " + entry.getKey().getPrice());
        }

        }
        
    }  

}
