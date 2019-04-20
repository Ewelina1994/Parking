public class Data
{
    private int rok,mc,dz;
    public Data(int r, int m, int d){
        rok=r;
        mc=m;
        dz=d;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",rok,mc,dz);
    }
    public boolean dataWczesnLubRowna(Data d){
        return (this.toString()).compareTo(d.toString())<=0;
    }
}