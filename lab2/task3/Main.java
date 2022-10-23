package task3;

class Shape {
    private double volume;

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}


class Box extends Shape {
    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return false;
        } else {
            double freeVolume = this.getVolume() - shape.getVolume();
            this.setVolume(freeVolume);
            return true;
        }
    }
}

class Pyramid extends Shape {
    private double s;
    private double h;
    
    Pyramid(double s, double h) {
        this.h = h;
        this.s = s;
        this.setVolume(s * h * 1/3);
    }
}

class SolidOfRevolution extends Shape {
    private double radius;

    SolidOfRevolution (double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    } 
}

class Cylinder extends SolidOfRevolution {
    Cylinder(double height, double radius) {
        super(radius); 
        this.setVolume(height*this.getRadius());
    }  
}

class Ball extends SolidOfRevolution {
    Ball(double radius) {
        super(radius);
        this.setVolume(Math.pow(super.getRadius(), 3)*Math.PI*4/3);
    }
}

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        box.setVolume(50);

        Ball ball1 = new Ball(2);
        System.out.println("Ball1 Volume: " + ball1.getVolume());
        System.out.println("\nBox Volume " + box.getVolume());
        System.out.println(box.add(ball1));
        System.out.println("\nBox Volume with ball1: " + box.getVolume());

        Cylinder cylinder1 = new Cylinder(10, 5);
        System.out.println("\nCylinder1 Volume: " + cylinder1.getVolume());
        System.out.println("\nBox Volume " + box.getVolume());
        System.out.println(box.add(cylinder1));
        System.out.println("\nBox Volume: " + box.getVolume());
    }
}
