package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Person;

public class PersonRepository {
    private List<Person>listPerson=new ArrayList<Person>();
    private Scanner scanner=new Scanner(System.in);
    // private MenuRepository mr;
    
    public void addPerson(Person p){
        System.out.println("=".repeat(35)+"\nADDING A PERSON...\n"+"=".repeat(35));
        listPerson.add(p);
    }

    public void inputPerson(Person p){

        System.out.println("=".repeat(75));
        System.out.println("|\t".repeat(2)+"¡READ THIS WITH CAREFUL!\nYOU CAN ONLY PUT A SENTENCE,"
        +"IF YOU TRY TO PUT A SPACE THE CONSOLE WILL FALL AND WILL APPEAR A ERROR.\n");
        System.out.println("=".repeat(75));
        System.out.print("Enter name:" );
        p.setName(scanner.next().toUpperCase());
        System.out.print("Enter Lastname: ");
        p.setLastName(scanner.next().toUpperCase());
        System.out.print("Enter IC: ");
        p.setIc(scanner.next());
        System.out.print("Enter Genre: ");
        p.setGenre(scanner.next().toUpperCase().charAt(0));
        System.out.print("Enter Age: ");
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35)+"\nERROR OF FONT..."+"\nPUT A NUMBER NOT A LETTER...\n"+"=".repeat(35));
        }
        p.setAge(scanner.nextInt());

        System.out.print("Enter Addres: ");
        p.setAddress(scanner.nextLine());
        System.out.print("Enter Email: ");
        p.setEmail(scanner.nextLine().toLowerCase());
        System.out.print("Enter Phone: ");
        p.setPhone(scanner.next().toUpperCase());
        System.out.print("Enter Role: ");
        p.setRole(scanner.next());
        System.out.print("Enter Password: ");
        p.setPassword(scanner.nextLine());

        addPerson(p);
    }

    public void removePerson(Person p){
        System.out.println("=".repeat(35)+"\nREMOVING A PERSON...\n"+"=".repeat(35));
        listPerson.remove(p);
    }

    public void allEditPerson(Person p){
        inputPerson(p);
    }
}
