import jdk.jshell.spi.SPIResolutionException;

public class Car {
    private int capacity;
    private double capacityPer;
    private int wish;
    private int timeOfCreation;


    public Car(int capacity, double capacityPer, int wish, int sec) {
        this.capacity = capacity;
        this.capacityPer = capacityPer;
        this.wish = wish;
        this.timeOfCreation = sec;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCapacityPer() {
        return capacityPer;
    }

    public int getWish() {
        return wish;
    }

    public int getTimeOfCreation() {
        return timeOfCreation;
    }
}
