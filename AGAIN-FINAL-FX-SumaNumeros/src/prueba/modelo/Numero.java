package prueba.modelo;

public class Numero {
    private long a,b;
    private double c,d;

    public Numero(long a, long b,long c,long d) {
        this.a = a;
        this.b = b;
        this.c=c;
        this.d=d;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
    
    public long sumacion(){
        return a+b;
    }

    public double sumacionDecimal(){
        return c+d;
    }
}
