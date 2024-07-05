import java.util.List;

import modelo.Libros;
import repositorio.LibrosRepositorio;

public class App {
    public static void main(String[] args) throws Exception {
        LibrosRepositorio librosRepositorio=new LibrosRepositorio();

        List<Libros> metodoLibros=librosRepositorio.libroGeneral();
        System.out.println("=".repeat(35)+"\nHAY UN TOTAL DE: "+metodoLibros.size()+" DE FILAS.\n"+"=".repeat(35));

        // String sql="titulo";
        List<Libros> metodoTitulo=librosRepositorio.libroTitulo(null);
        // System.out.println("=".repeat(35)+"\n"+metodoLibros+"\n"+"=".repeat(35));

        for (Libros libros : metodoTitulo) {
            System.out.println("=".repeat(35)+"\n"+libros.getTitulo()+"\n"+"=".repeat(35));
        }
    }
}
