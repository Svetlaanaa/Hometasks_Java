package Hometask_2.Task2;
import java.util.Random;

public class GaussRandom {
    private Random random;
    private boolean isCos = true;

    public GaussRandom() {
        random = new Random();
    }

    public GaussRandom(int seed) {
        random = new Random(seed);
    }

    public double nextNormal(double m, double sigma) {
        double u1 = random.nextDouble();
        double u2 = random.nextDouble();
        double z;
        if(isCos)
            z = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);
        else
            z = Math.sqrt(-2.0 * Math.log(u1)) * Math.sin(2.0 * Math.PI * u2);
        return m + sigma * z;
    }

    public double nextNormal() {
        return nextNormal(0.0, 1.0);
    }
}