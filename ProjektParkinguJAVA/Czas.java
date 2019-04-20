import java.util.*;
public class Czas
{
    private int rok,mc,dz,godz,min;

    public Czas(){
        Calendar calendar = new GregorianCalendar();
        Date data = new Date();
        calendar.setTime(data);
        rok=calendar.get(Calendar.YEAR);
        mc=calendar.get(Calendar.MONTH)+1;
        dz=calendar.get(Calendar.DAY_OF_MONTH);
        godz=calendar.get(Calendar.HOUR_OF_DAY);
        min=calendar.get(Calendar.MINUTE);
    }
    public String toString(){
        return String.format("%04d-%02d-%02d %02d:%02d",rok,mc,dz,godz,min);
    }
    public long dajLiczbeGodzin(){
        return rok%1000*1000000+mc*10000+dz*100+godz+Math.round(min/60.0);
    }
    public Data dajDate(){
        return new Data(rok,mc,dz);
    }
}
