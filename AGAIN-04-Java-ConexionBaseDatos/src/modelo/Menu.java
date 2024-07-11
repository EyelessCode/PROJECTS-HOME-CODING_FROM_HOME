package modelo;

public class Menu {
    private int opcion;
    private String texto;
    
    public Menu(int opcion, String texto) {
        this.opcion = opcion;
        this.texto = texto;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
