public class BrakTakiegoPojazdu extends Exception
{
    public BrakTakiegoPojazdu(long nr){
        super("Pr�ba wyjazdu pojazdu o numerze parkingowym "+nr+" - brak takiego pojazdu");
    }
}
