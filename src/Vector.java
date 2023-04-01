import java.util.Arrays;

public class Vector {
    private double[] cords;

    public Vector(double[] cords) {
        this.cords = cords;
    }

    public double scalProd(Vector v2) {
        double result = 0.0;
        for (int i = 0; i < cords.length; i++) {
            result += this.cords[i] * v2.cords[i];
        }
        return result;
    }

    public Vector sum(Vector v2) {
        double[] result = new double[cords.length];
        for (int i = 0; i < cords.length; i++) {
            result[i] = this.cords[i] + v2.cords[i];
        }
        return new Vector(result);
    }

    public Vector razn(Vector v2) {
        double[] result = new double[cords.length];
        for (int i = 0; i < cords.length; i++) {
            result[i] = this.cords[i] - v2.cords[i];
        }
        return new Vector(result);
    }

    public Vector multip(double scalar) {
        double[] result = new double[cords.length];
        for (int i = 0; i < cords.length; i++) {
            result[i] = this.cords[i] * scalar;
        }
        return new Vector(result);
    }

    public double angle(Vector v2) {
        double scalProd = scalProd(v2);
        double len1 = len();
        double len2 = v2.len();
        return Math.acos(scalProd / (len1 * len2));
    }

    public double len() {
        double sum = 0.0;
        for (double cords : cords) {
            sum += cords * cords;
        }
        return Math.sqrt(sum);
    }

    public double paral(Vector v2) {
        double angle = angle(v2);
        double len1 = len();
        double len2 = v2.len();
        return len1 * len2 * Math.sin(angle);
    }

    @Override
    public String toString() {
        return Arrays.toString(cords);
    }
}
