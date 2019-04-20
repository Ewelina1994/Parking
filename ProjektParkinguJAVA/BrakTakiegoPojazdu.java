public class BrakTakiegoPojazdu extends Exception
{
    public BrakTakiegoPojazdu(long nr){
        super("Próba wyjazdu pojazdu o numerze parkingowym "+nr+" - brak takiego pojazdu");
    }
}
