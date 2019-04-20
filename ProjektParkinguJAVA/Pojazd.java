public abstract class Pojazd
{
    protected String nrRej;
    protected int typ;
    
    public Pojazd(String nrRej, int typ){
        this.nrRej=nrRej;
        this.typ=typ;
    }

    public int dajTyp(){
        return typ;
    }
    public String dajNrRej(){
        return nrRej;
    }    
}


