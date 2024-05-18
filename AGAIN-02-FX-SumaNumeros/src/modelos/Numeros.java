package modelos;

public class Numeros {
    private long a;
    private long b;
    
    public Numeros(long a, long b) {
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

    public long suma(){
        return a+b;
    }
}
