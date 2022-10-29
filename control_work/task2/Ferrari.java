package task2;

public class Ferrari extends Car{
    private int year;

    public Ferrari(String color, int maxSpeed, String gearbox, int price, int year) {
        super(color, maxSpeed, gearbox, price);
        this.year = year;
        // Auto-generated constructor stub
    }

    public void setMaxSpeed (int speed) {
        this.maxSpeed = speed;
    }

    public void accelerateTo300(){
        this.setCurrentSpeed(300);
    }

    public int getYear() {
        return this.year;
    }
    
}
