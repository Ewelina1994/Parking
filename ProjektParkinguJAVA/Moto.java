public class Moto extends Pojazd
{
    public Moto(String nrRej){
        super(nrRej,Parametry.TYP_MOTO);
    }

    public String toString(){
        return "Motocykl nr rej. "+nrRej;
    }
}
