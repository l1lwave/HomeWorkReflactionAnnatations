package task3;

public class Car {
    @Save
    private String color;
    @Save
    private int speed;
    private String serialNumber;

    public Car(String color, int speed, String serialNumber) {
        this.color = color;
        this.speed = speed;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
