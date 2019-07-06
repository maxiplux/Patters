package observer;

import lombok.Data;
import observer.generics.AbstractObservable;
import observer.generics.Observable;
import observer.generics.ObserverA;
import observer.generics.ObserverB;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


public class SingleConfigurationManager extends AbstractObservable {

    private static SingleConfigurationManager configurationManager;

    private SimpleDateFormat simpleDateFormat;
    private NumberFormat numberFormat;


    public static SingleConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public static void setConfigurationManager(SingleConfigurationManager configurationManager) {
        SingleConfigurationManager.configurationManager = configurationManager;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        this.notifyAllObsesrver("setSimpleDateFormat", this);
    }

    public NumberFormat getNumberFormat() {


        return numberFormat;
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
        this.notifyAllObsesrver("numberFormat", this);
    }

    private SingleConfigurationManager(){};

    public  synchronized static SingleConfigurationManager getInstance()
    {
        if (configurationManager == null)
        {
            configurationManager = new SingleConfigurationManager();
        }
        return  configurationManager;
    }

    public static void main(String[] args) {
        SingleConfigurationManager singleConfigurationManager = SingleConfigurationManager.getInstance();

        //Se establecen los valores por default.
        singleConfigurationManager.setSimpleDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        singleConfigurationManager.setNumberFormat(new DecimalFormat("##.00"));
        System.out.println("Established configuration");

        //Se dan de alta lo observers
        ObserverA dateFormatObserver = new ObserverA();
        ObserverB moneyFormatObserver = new ObserverB();

        singleConfigurationManager.addObserver(dateFormatObserver);
        singleConfigurationManager.addObserver(moneyFormatObserver);

        System.out.println("1111111111111");

        //Se cambia la fonfiguratión
        singleConfigurationManager.setSimpleDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        singleConfigurationManager.setNumberFormat(new DecimalFormat("###,#00.00"));
        System.out.println("222222222222");

        //Se realiza otro cambio en la configuración.
        singleConfigurationManager.setSimpleDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        singleConfigurationManager.setNumberFormat(new DecimalFormat("###,#00"));

        singleConfigurationManager.removeObserver(dateFormatObserver);
        singleConfigurationManager.removeObserver(moneyFormatObserver);
        System.out.println("");

        //Se realiza otro cambio en la configuración.
        singleConfigurationManager.setSimpleDateFormat(new SimpleDateFormat("MM/yyyy"));
        singleConfigurationManager.setNumberFormat(new DecimalFormat("###,##0.00"));

    }
}
