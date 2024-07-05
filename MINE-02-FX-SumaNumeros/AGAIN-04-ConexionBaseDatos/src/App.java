import java.util.List;

import modelo.Libros;
import repositorio.LibrosRepositorio;

public class App {
    public static void main(String[] args) throws Exception {
        LibrosRepositorio librosRepositorio=new LibrosRepositorio();

        List<Libros> metodoLibros=librosRepositorio.libroGeneral();
        System.out.println("=".repeat(35)+"\nHAY UN TOTAL DE: "+metodoLibros.size()+" DE FILAS.\n"+"=".repeat(35));
        // System.out.println("HAY UN TOTAL DE: "+metodoLibros.size()+" DE FILAS."); 
        // System.out.println("=".repeat(35));
    }
}
