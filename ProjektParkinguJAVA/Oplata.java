public class Oplata implements Comparable
{
    long lp;
    Pojazd pojazd;
    Czas czas_wjazdu,czas_wyjazdu;
    int nrMiejsca, liczbaGodzin;
    double oplataJedn,kwota;

    public String toString(){
        return pojazd+", "+czas_wjazdu+" - "+czas_wyjazdu+": "+liczbaGodzin+" godz. * "+String.format("%4.2f = %5.2f",oplataJedn,kwota);
    }

    public Oplata(long lp, Pojazd pojazd, Czas czas_wjazdu,
    int nrMiejsca, double oplataZaGodz){
        this.lp=lp;
        this.pojazd=pojazd;
        this.czas_wjazdu=czas_wjazdu;
        this.nrMiejsca=nrMiejsca;
        oplataJedn=oplataZaGodz;
        liczbaGodzin=0;
        kwota=0;
    }

    private int liczbaJednostekCzasu(Czas czas_pocz, Czas czas_konc){
        int lgodz = (int) (czas_konc.dajLiczbeGodzin()-czas_pocz.dajLiczbeGodzin());
        return lgodz==0? 1 : lgodz;
    }
    public long dajLp() {
        return lp;
    }
    
    public Pojazd dajPojazd(){
        return pojazd;
    }

    public void wyliczKwote(Czas czas){
        czas_wyjazdu=czas;
        liczbaGodzin =  liczbaJednostekCzasu(czas_wjazdu,czas_wyjazdu);
        kwota = oplataJedn * liczbaGodzin;
    }

    public int compareTo(Object opl){
        int lopl = (int) (lp - ((Oplata)opl).dajLp());      
        return lopl;
    }
}
