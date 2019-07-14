package strategy;

import strategy.concrete.Circle;
import strategy.concrete.Line;
import strategy.concrete.Reactanle;
import strategy.generics.ContextStragtegy;
import strategy.generics.ContextStragtegyImpl;



public class Aplication {
    public static void main(String[] args) {

        ContextStragtegy context =  new ContextStragtegyImpl(new Line());
        context.draw();
        context.setStrategy(new Circle());
        context.draw();
        context.setStrategy(new Reactanle());
        context.draw();

    }
}

