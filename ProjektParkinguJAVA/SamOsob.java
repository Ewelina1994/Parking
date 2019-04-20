public class SamOsob extends Pojazd
{
    public SamOsob(String nrRej){
        super(nrRej,Parametry.TYP_SAMOSOB);
    }

    public String toString(){
        return "Samochód osobowy nr rej. "+nrRej;
    }
}


