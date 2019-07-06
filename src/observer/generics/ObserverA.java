package observer.generics;

public class ObserverA implements Observer  {

    @Override
    public void notify(String change, Object source) {
        System.out.printf("Change on observervable obceject %s  ---- %s" ,change, source.toString());
    }
}
