import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner scanner=new Scanner(System.in);
    public static List<Person> l=new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        boolean puerta=false;

        while (puerta) {
            menuDeBienvenida();
            int opcion=ingreso();

            switch (opcion) {
                case 1:
                    agregar();
                    break;
            
                default:
                    break;
            }
        }
    }
    
    public static void menuDeBienvenida(){

        System.out.println("BIENVENIDO A NUESTRO SERVICIO");
        System.out.println("---Htechealth---");
        System.out.println("|> MENÚ");
        System.out.println("|> 1. REGISTRARSE");
        System.out.println("|> 2. AYUDA");
        System.out.println("|> 3. SALIR");
    }
    
    public static int ingreso(){
        System.out.print("|________>: ");
        while (!scanner.hasNextInt()) {
            System.out.println("!".repeat(30));
            System.out.println("INGRESE UN DÍGITO. NO UNA LETRA");
            System.out.println("!".repeat(30));
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void agregar(){
        
    }
}
