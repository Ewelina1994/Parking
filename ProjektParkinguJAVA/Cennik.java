import java.util.*;
public class Cennik
{
    HashMap<Integer,Double> cennik;
    Cennik(){
        cennik=new HashMap<Integer,Double>();
    }
    public void dopiszOplate(int tp, double op){
       cennik.put(tp,op);
    }
    public double dajOplate(int tp){
        Double d = cennik.get(tp);
        return d!=null? (double) d : 0.0;
    };
    public String dajCennik(){
        return cennik.toString();
    }
}
