package Hometask_2.Task1;

import java.util.Date;

public abstract class B extends A {
    private double varB1;

    public double getB1() {
        return varB1;
    }

    public void setB1(double varB1) {
        this.varB1 = varB1;
    }

    @Override
    public abstract int foo(Date dt);
}
