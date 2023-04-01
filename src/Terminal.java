public class Terminal {
    private int busyTill;
    public Terminal() {
    }

    boolean fuelAdd(Car car, Station station, int sec){
        int wish = car.getWish();
        int stCap = station.getCapacity();
        if (stCap - wish > 0){
            int minus = stCap - wish;
            station.setCapacity(minus);
            busyTill = sec + (int) Math.ceil(wish / 0.333);
            return true;
        }
        else {return false;}
    }
    boolean isBusy(int sec){
        if (busyTill <= sec){
            return false;
        }
        return true;
    }
}