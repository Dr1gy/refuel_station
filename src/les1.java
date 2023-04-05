public class les1 {
    public static void main(String[] args) {
        double a = -100.0; // левая граница
        double b = 100.0; // правая граница
        double eps = 0.0001; // точность
        int maxIterations = 100;

        double c = (a + b) / 2.0; // середина
        int iteration = 0; // счетчик итераций

        while (Math.abs(b - a) > eps && iteration < maxIterations) {
            double fa = f(a);
            double fb = f(b);
            double fc = f(c);

            if (fa * fc < 0.0) {
                b = c;
            } else if (fb * fc < 0.0) {
                a = c;
            } else {
                break; // не выполнено условие сходимости
            }

            c = (a + b) / 2.0; // новое значение середины интервала
            iteration++; // увеличиваем счетчик итераций
        }

        System.out.println(c);
    }

    public static double f(double x) {
        return x * x * x + x + 1;
    }
}
