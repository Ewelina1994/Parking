public class SamOsob extends Pojazd
{
    public SamOsob(String nrRej){
        super(nrRej,Parametry.TYP_SAMOSOB);
    }

    public String toString(){
        return "Samoch�d osobowy nr rej. "+nrRej;
    }
}


