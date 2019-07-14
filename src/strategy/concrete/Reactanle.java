package strategy.concrete;

import strategy.generics.ShapeStrategy;

public class Reactanle implements ShapeStrategy {
    @Override
    public void draw() {
        System.out.println("Drawing a Reactanle");
    }
}
