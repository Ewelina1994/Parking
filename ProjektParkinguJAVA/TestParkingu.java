import java.util.*;
public class TestParkingu
{
    public static void main(String[] args){
        Cennik c=new Cennik();
        c.dopiszOplate(Parametry.TYP_SAMOSOB,3.50);
        c.dopiszOplate(Parametry.TYP_MOTO,2.50);
        System.out.println("Zakladanie cennika:");
        System.out.println(c.dajCennik());
        System.out.println("Zakladanie parkingu:");
        Parking parking=new Parking(c);
            parking.wyswietlStanParkingu();
        
        long nrWjazdu1=parking.wjazd(new SamOsob("DSW08190"));
            parking.wyswietlStanParkingu();
            
        try { parking.wyjazd(nrWjazdu1); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }

        long nrWjazdu2=parking.wjazd(new SamOsob("DSW26655")); 
            parking.wyswietlStanParkingu();

        long nrWjazdu3=parking.wjazd(new Moto("DW12345")); 
            parking.wyswietlStanParkingu();

        long nrWjazdu4=parking.wjazd(new SamOsob("WG54321"));
            parking.wyswietlStanParkingu();

        try { parking.wyjazd(nrWjazdu2); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }

        long nrWjazdu5=parking.wjazd(new Moto("FZA54765"));
            parking.wyswietlStanParkingu();            
            
        try { parking.wyjazd(nrWjazdu4); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();
            
        try { parking.wyjazd(nrWjazdu4); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();
            
        try { parking.wyjazd(nrWjazdu3); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();

        long nrWjazdu6=parking.wjazd(new Moto("JJ012345"));
            parking.wyswietlStanParkingu();
        long nrWjazdu7=parking.wjazd(new SamOsob("KT876543"));
            parking.wyswietlStanParkingu();
        long nrWjazdu8=parking.wjazd(new Moto("PKA51423"));
            parking.wyswietlStanParkingu();

         try { parking.wyjazd(nrWjazdu2); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();
 
            try { parking.wyjazd(nrWjazdu7); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();

        long nrWjazdu11=parking.wjazd(new SamOsob("DSW26655")); 
            parking.wyswietlStanParkingu();
            
        long nrWjazdu12=parking.wjazd(new SamOsob("DSW08190"));
            parking.wyswietlStanParkingu();

        try { parking.wyjazd(nrWjazdu7); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();

            parking.dajSumeOplat(new Data(2012,4,1),new Data(2012,4,24));
            parking.dajSumeOplat(new Data(2012,4,25),new Data(2012,4,25));
            parking.dajSumeOplat(new Data(2012,4,26),new Data(2012,4,30));
            parking.dajSumeOplat(new Data(2012,4,1),new Data(2012,4,30));

            parking.dajSumeOplatPojazdu("DSW08190",new Data(2012,4,1),new Data(2012,4,30));
            parking.dajSumeOplatPojazdu("DSW26655",new Data(2012,4,1),new Data(2012,4,30));

        try { parking.wyjazd(nrWjazdu12); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }
            parking.wyswietlStanParkingu();
           
        try { parking.wyjazd(nrWjazdu11); }
        catch (BrakTakiegoPojazdu e) { System.out.println(e.getMessage()); }           
            parking.wyswietlStanParkingu();
            
            parking.dajSumeOplatPojazdu("DSW08190",new Data(2012,4,1),new Data(2012,4,30));
            parking.dajSumeOplatPojazdu("DSW26655",new Data(2012,4,1),new Data(2012,4,30));
                    }
}