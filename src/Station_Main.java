import java.util.Arrays;
import java.util.Random;
public class Station_Main {
    public static void main(String[] args) {
        Station station = new Station(10_000);
        int sec = 0;int min = 0;int hour = 0;int day = 0; int newTerminal = -1; int f = 0;
        boolean madeInHeaven = true;
        Car[] cars = new Car[1000000];
        Random random = new Random();
        Terminal[] terminals = new Terminal[100];
        int termCount = 3;
        terminals[0] = new Terminal();
        terminals[1] = new Terminal();
        terminals[2] = new Terminal();

        while (true){
            if (madeInHeaven) {
                int carAppears = random.nextInt(300 - 0 + 1) + 1;
                if (carAppears == 1) {
                    int cap = random.nextInt(51) + 50;                      //бак 50 - 100 л // thanks chat-GPT
                    double per1 = random.nextInt(31) + 20 * cap / 100.0;    // нецелое число - % заполнения (20 - 50 %) // thanks chat-GPT
                    int per = (int) per1 - 1;
                    int wish = random.nextInt((cap - per - 1) - 1 + 1) + 1;
                    Car car = new Car(cap, per, wish, sec);
                    int carsCount = 0;
                    while (cars[carsCount] != null) {
                        carsCount++;
                    }
                    cars[carsCount] = car;
                }

                if (cars[0] != null) {                                                       //если есть машины, то проходим по всем колонкам
                    for (int j = 0; j < termCount; j++) {
                        if (terminals[j].isBusy(sec) == false) {                             // занята ли jая колонка
                            int time = cars[0].getTimeOfCreation();
                            if ((sec - time) >= (12 * 60)) {
                                f ++;                                                      // флаг для 12 мин
                            }
                            if ((sec-time) >= 15 * 60){         // уезжает через 15 мин
                                cars[0] = null;
                                int l = 1;
                                while (cars[l] != null) {
                                    cars[l - 1] = cars[l];
                                    l++;
                                }
                            }
                            madeInHeaven = terminals[j].fuelAdd(cars[0], station, sec);
                            cars[0] = null;
                            int l = 1;
                            while (cars[l] != null) {
                                cars[l - 1] = cars[l];
                                l++;
                            }
                            break;
                        }
                    }
                }
            }
            sec++;
            if (!(madeInHeaven)){
                sec = 86_400;
            }
            if (sec >= 86_400){
                day++;
                sec = 0;
                Arrays.fill(cars, null);                        // thanks chat-GPT
                for (int o = 0; o < termCount; o++){
                    terminals[o] = new Terminal();
                }
                station.setCapacity(station.getCapacity() + 6_000);
                madeInHeaven = true;
                System.out.println("день " + day + " закончился");

                if (f >= 1){
                    newTerminal = day + 2;
                    f = -999999999;       // ставка на каждый загруженый день // переделано
                }
                if (newTerminal == day){                                     //открытие новой калонки
                    terminals[termCount] = new Terminal();
                    termCount ++;
                    newTerminal = -1;
                    f = 0;
                }
            }

            if ((sec == 21_600) || (sec == 43_200) || (sec == 64_800) || (sec == 86_399)){
                int carsCount = 0;
                while (cars[carsCount] != null) {
                    carsCount++;
                }
                int q = carsCount;
                System.out.print("очередь:" + q + " ");
                System.out.print("кол-во колонок:" + termCount + " ");
                System.out.println("Кол-во топлива:" + station.getCapacity() + " ");
            }
        }
    }
}