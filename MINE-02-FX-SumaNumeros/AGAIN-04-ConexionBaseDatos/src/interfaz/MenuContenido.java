package interfaz;

import java.util.List;
import java.util.Scanner;

import modelo.Libros;
import repositorio.LibrosRepositorio;

public class MenuContenido {
    Scanner entrada=new Scanner(System.in);
    LibrosRepositorio lr=new LibrosRepositorio();

    public void contenidoOpciones(){
        boolean puerta=true;

        while (puerta) {
            menu();
            int opcion=entradaOpcion();
            switch (opcion) {
                case 1: List<Libros> libroGeneral=lr.libroGeneral();
                    break;
            
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("=".repeat(75)+"\nMENÚ");
        System.out.println("1. PRESENTAR LA TABLA 'LIBRO'.");
        System.out.println("2. PRESENTAR EL CAMPO 'TÍTULO' DE LA TABLA 'LIBRO'");
        System.out.println("3. SALIR.");
    }

    public int entradaOpcion(){
        System.out.println("\n\n"+"=".repeat(45)+"\nSELECCIONA UNA OPCIÓN: ");

        while (!entrada.hasNextInt()) {
            System.out.println("\n\n"+"=".repeat(35)+"\n¡ENTRADA INVÁLIDA!");
            entrada.next();
        }
        return entrada.nextInt();
    }
}
