package Hometask_2.Task2;

public class Main {
    public static void main(String[] args) {
        GaussRandom gaussRandom = new GaussRandom();
        System.out.println(gaussRandom.nextNormal());

        GaussRandom gaussRandom1 = new GaussRandom();
        System.out.println(gaussRandom1.nextNormal(1,3));
    }
}
