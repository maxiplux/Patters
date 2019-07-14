package strategy.concrete;

import strategy.generics.ShapeStrategy;

public class Circle implements ShapeStrategy {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
