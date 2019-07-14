package observer;

import observer.generics.Observer;

public class ObserverA implements Observer {

    @Override
    public void notify(String change, Object source) {
        System.out.printf("Change on observervable obceject %s  ---- %s" ,change, source.toString());
    }
}
