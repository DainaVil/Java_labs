package task2;

// Абстрактный класс, нельзя создавать его эксемпляры
public abstract class Car {

    // переменные private защищены
    private String color;
    protected int maxSpeed; 
    private final String gearbox;
    private int currentSpeed;
    private int price;

    public Car(String color, int maxSpeed, String gearbox, int price){
        this.setColor(color);
        this.setPrice(price);
        this.maxSpeed = maxSpeed;
        this.gearbox = gearbox;
    }

    public void start() {
        this.currentSpeed = 10; // допустим, что на нейтралке после старта
    }

    public void stop() {
        this.currentSpeed = 0;
    }

    public void accelerate(int speed) {
        if (this.currentSpeed + speed < this.maxSpeed) {
            this.currentSpeed += speed;
        } else {
            System.out.println("Максимальная скорость");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", " + this.color;
    }

    // Cеттеры и геттеры для переменных
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public String getGearbox() {
        return gearbox;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
