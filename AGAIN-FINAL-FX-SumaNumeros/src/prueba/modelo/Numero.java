package prueba.modelo;

public class Numero {
    private long a,b;

    public Numero(long a, long b) {
        this.a = a;
        this.b = b;
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
    
    public long sumacion(){
        return a+b;
    }
}
