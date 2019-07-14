package strategy.concrete;

import strategy.generics.ShapeStrategy;

public class Line implements ShapeStrategy {
    @Override
    public void draw() {
        System.out.println("Drawing a Line");
    }
}
