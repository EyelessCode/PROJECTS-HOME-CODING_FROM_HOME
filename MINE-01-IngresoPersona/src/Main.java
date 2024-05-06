import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                case 2:
                    sectorAyuda();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("DÍGITE ENTRE LAS OPCIONES QUE HAY...");
            }
        }
        scanner.close();
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
        Person p=new Person(null, null, 0);

        System.out.print("Cédula: ");
        p.setNombre(scanner.next());
        System.out.print("Nombre: ");
        p.setNombre(scanner.next());
        System.out.print("Edad: ");
        if(scanner.hasNextInt()){
            p.setEdad(scanner.nextInt());
        }else{
            System.out.println("!".repeat(30));
            System.out.println("INGRESE UN DÍGITO. NO UNA LETRA");
            System.out.println("!".repeat(30));
        }
        // while (!scanner.hasNextInt()) {
        //     System.out.println("!".repeat(30));
        //     System.out.println("INGRESE UN DÍGITO. NO UNA LETRA");
        //     System.out.println("!".repeat(30));            
        // }
        // p.setEdad(scanner.nextInt());
        System.out.println("PERSONA REGISTRADA");
        l.add(p);
    }

    public static void sectorAyuda(){
        System.out.println("GUÍA ESTABLECIDO. PRESTE ATENCIÓN");
        System.out.println("1er paso.- Al momento de empezar tiene que digitar una de las opciones a la que quiera acceder. No puede digitar un número fuera de las opciones, mucho menos ingresar una letra.");
        System.out.println("2do paso.- Luego de digitar e ingresar a una opción...");
        System.out.println("...");
        // scanner.next();
        menuDeBienvenida();
    }
}
