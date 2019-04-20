import java.util.*;
public class Parking implements Statystyka
{
    Cennik cennik;
    final int MAX=5;
    ArrayList<Miejsce> miejsca;
    HashMap<Long,Oplata> oplaty;
    long lpPojazdu=0;
    int zapelnienie=0;

    private Parking(){};

    public Parking(Cennik cennik)
    {
        this.cennik=cennik;
        miejsca=new ArrayList<Miejsce>();
        oplaty =new HashMap<Long,Oplata>();
        for (int i=0; i<MAX; i++)
            miejsca.add(new Miejsce(i+1));
    }

    public void dajSumeOplat(Data odDnia, Data doDnia) {
        double suma=0; 
        Oplata o;
        if (odDnia.dataWczesnLubRowna(doDnia)){
            Collection<Oplata> c=oplaty.values();
            Iterator<Oplata> i = c.iterator();
            while (i.hasNext()){
                o=i.next();
                if (o.kwota>0)
                    if (o.czas_wyjazdu.dajDate().dataWczesnLubRowna(doDnia))
                        if (odDnia.dataWczesnLubRowna(o.czas_wyjazdu.dajDate())){
                            suma+=o.kwota;
                }
            }
        }
        System.out.println("Suma oplat w okresie od "+odDnia+" do "+doDnia+
            " wynosi "+String.format("%6.2f",suma)+" zl");
    }

    public void dajSumeOplatPojazdu(String nrRej, Data odDnia, Data doDnia) {
        double suma=0; 
        Oplata o;
        if (odDnia.dataWczesnLubRowna(doDnia)){
            Collection<Oplata> c=oplaty.values();
            Iterator<Oplata> i = c.iterator();
            while (i.hasNext()){
                o=i.next();
                if (o.pojazd.dajNrRej().equals(nrRej))
                    if (o.kwota>0)
                        if (o.czas_wyjazdu.dajDate().dataWczesnLubRowna(doDnia))
                            if (odDnia.dataWczesnLubRowna(o.czas_wyjazdu.dajDate())){
                                suma+=o.kwota;
                }
            }
        }
        System.out.println("Suma oplat pojazdu "+nrRej+" w okresie od "+odDnia+" do "+doDnia+
            " wynosi "+String.format("%6.2f",suma)+" zl");
    }

    public void wyswietlStanParkingu() {
        Iterator<Miejsce> iterator=miejsca.iterator();
        System.out.println("   Stan parkingu:");
        while (iterator.hasNext()){
            System.out.println("   "+iterator.next().pokazMiejsce());
        }
    }

    boolean wolny(){
        return zapelnienie<MAX;
    }

    public long wjazd(Pojazd pojazd){
        if (pojazd!=null) {
            if (!wolny()) System.out.println("Próba wjazdu pojazdu: "+pojazd+" - Brak wolnych miejsc");
            else {
                Miejsce miejsce=dajWolneMiejsce();
                if (miejsce!=null) {
                    lpPojazdu++;
                    Czas czas_wjazdu=miejsce.zajmijMiejsce(lpPojazdu,pojazd);
                    Oplata oplata = new Oplata(lpPojazdu,pojazd,czas_wjazdu,miejsce.dajNumer(),
                            cennik.dajOplate(pojazd.dajTyp()));
                    Oplata o = oplaty.put(lpPojazdu,oplata);
                    System.out.println("Wjazd:  => "+pojazd+", "+czas_wjazdu);
                    zapelnienie++;
                } 
            }
        }
        return lpPojazdu;
    }

    public void wyjazd(long lp) throws BrakTakiegoPojazdu {
        Iterator<Miejsce> iterator = miejsca.iterator();
        Miejsce miejsce=null;
        Oplata o = null;
        while (iterator.hasNext()){
            miejsce = iterator.next();
            if (miejsce.lp==lp) {
                o = oplaty.get(lp);
                if (o!=null) {
                    Czas czas = miejsce.zwolnijMiejsce();
                    o.wyliczKwote(czas); 
                    zapelnienie--;
                    System.out.println("Wyjazd: <= "+o);
                }
            }
        } 
        if (o==null) throw new BrakTakiegoPojazdu(lp);
    }

    public Pojazd dajPojazd(long lp) throws BrakTakiegoPojazdu {
        Oplata o=oplaty.get(lp);
        if (o==null) throw new BrakTakiegoPojazdu(lp);
        return o.dajPojazd();
    }

    private Miejsce dajWolneMiejsce() {
        Iterator<Miejsce> iterator=miejsca.iterator();
        while (iterator.hasNext()){
            Miejsce m=iterator.next();
            if (m.wolne()) return m;
        }
        return null;
    }

    private class Miejsce {
        long lp; // autonumer kolejnego auta na parkingu
        int nrMiejsca;
        Pojazd pojazd;
        boolean wolne;
        Czas wjazd;
        Miejsce(int nrM){
            lp=0;
            nrMiejsca=nrM;
            pojazd=null;
            wolne=true;
            wjazd=null;
        }

        String pokazMiejsce(){
            return wolne==true ? nrMiejsca+": wolne" : nrMiejsca+": "+pojazd.dajNrRej()+" ("+lp+")";
        }

        boolean wolne(){
            return wolne;
        }

        Czas zajmijMiejsce(long lp, Pojazd pojazd){
            this.lp=lp;
            this.pojazd=pojazd;
            wolne=false;
            wjazd=new Czas();
            return wjazd;
        }

        Czas zwolnijMiejsce(){
            lp=0;
            wolne=true;
            return new Czas();
        }

        int dajNumer(){
            return nrMiejsca;
        }
    }
}
