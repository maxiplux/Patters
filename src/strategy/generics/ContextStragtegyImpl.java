package strategy.generics;

public class ContextStragtegyImpl implements ContextStragtegy {

    private ShapeStrategy strategy;

    public ContextStragtegyImpl(ShapeStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setStrategy(ShapeStrategy strategy) {
        this.strategy = strategy;

    }

    @Override
    public void  draw()
    {
        this.strategy.draw();
    }


}
