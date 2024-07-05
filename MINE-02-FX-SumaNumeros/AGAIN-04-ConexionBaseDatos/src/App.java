import java.util.List;

import modelo.Libros;
import repositorio.LibrosRepositorio;

public class App {
    public static void main(String[] args) throws Exception {
        LibrosRepositorio librosRepositorio=new LibrosRepositorio();

        List<Libros> metodoLibros=librosRepositorio.libroGeneral();
        System.out.println("=".repeat(35)+"\nHAY UN TOTAL DE: "+metodoLibros.size()+" DE FILAS.\n"+"=".repeat(35));
        
        System.out.println("=".repeat(80)+"\nID  "+"TÍTULO\t"+"ISBN\t\t"+"N° PÁGINAS   "+"FECHA DE PUBLICACIÓN   "+"ID Autor   "+"ID CATEGORÍA   "+"ID EDITORIAL\n");
        for (Libros libros : metodoLibros) {
            System.out.println(libros.getId()+"   "+libros.getTitulo()+"\t"+libros.getIsbn()+"\t\t"+libros.getNumPaginas()+"   "+libros.getFechaPublicacion()+"   "+libros.getIdAutor()+"   "+libros.getIdCategoria()+"   "+libros.getIdEditorial()+"\n");
        }
        System.out.println("=".repeat(80));

        // String sql="titulo";
        List<Libros> metodoTitulo=librosRepositorio.libroTitulo(null);
        // System.out.println("=".repeat(35)+"\n"+metodoLibros+"\n"+"=".repeat(35));

        System.out.println("=".repeat(35)+"\nTÍTULO\n");
        for (Libros libros : metodoTitulo) {
            System.out.println(libros.getTitulo()+"\n");
        }
        System.out.println("=".repeat(35));
    }
}
