package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Person;

public class PersonRepository {
    private Person p;
    private List<Person>listPerson=new ArrayList<Person>();
    private Scanner scanner=new Scanner(System.in);
    // private MenuRepository mr;
    
    public void addPerson(Person p){
        System.out.println("=".repeat(35)+"\nADDING A PERSON...\n"+"=".repeat(35));
        listPerson.add(p);
    }

    public void inputPerson(Person p){
        System.out.println("=".repeat(75));
        System.out.println("|\n".repeat(2)+"\n¡READ THIS WITH CAREFUL!\nYOU CAN ONLY PUT A SENTENCE,"
        +"IF YOU TRY TO PUT A SPACE THE CONSOLE WILL FALL AND WILL APPEAR AN ERROR.\n");
        System.out.println("=".repeat(75));
        System.out.print("Enter name: " );
        p.setName(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.print("Enter Lastname: ");
        p.setLastName(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.print("Enter IC: ");
        p.setIc(scanner.next());
        scanner.nextLine();
        System.out.print("Enter Genre: ");
        p.setGenre(scanner.next().toUpperCase().charAt(0));
        scanner.nextLine();
        System.out.print("Enter Age: ");
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35)+"\nERROR OF FONT..."+"\nPUT A NUMBER NOT A LETTER...\n"+"=".repeat(35));
            scanner.next();
        }
        p.setAge(scanner.nextInt());
        scanner.nextLine();
        
        System.out.print("Enter Addres: ");
        p.setAddress(scanner.nextLine());
        // scanner.next();
        System.out.print("Enter Email: ");
        p.setEmail(scanner.nextLine().toLowerCase());
        // scanner.next();
        System.out.print("Enter Phone: ");
        p.setPhone(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.print("Enter Role: ");
        p.setRole(scanner.next());
        scanner.nextLine();
        System.out.print("Enter Password: ");
        p.setPassword(scanner.nextLine());
        // scanner.next();

        addPerson(p);
    }

    public void removePerson(){
        System.out.println("=".repeat(35)+"\nREMOVING A PERSON...\n"+"=".repeat(35));
        listPerson.remove(p);
    }

    public void allEditPerson(){
        inputPerson(p);
    }

    public void showPerson(){
        for (Person p : listPerson) {
            System.out.printf("=".repeat(50)+"\nNAME: %s \tLAST NAME: %s \tGENRE: %s"
            +"\tAGE: %d \tADDRESS: %s \nPHONE: %s \tEMAIL: %s"
            +"\tPASSWORD: %s \tROLE: %s \tIC: %s \n"+"=".repeat(50),
            p.getName(),p.getLastName(),p.getGenre(),p.getAge(),p.getAddress(),
            p.getPhone(),p.getEmail(),p.getPassword(),p.getRole(),p.getIc());
        }
    }

    public void showPersonIc(){
        for (Person p : listPerson) {
            System.out.printf("=".repeat(35)+"\nIC: %s \n"+"=".repeat(35),p.getIc());
        }
    }

    public void showPersonName(){
        for (Person p : listPerson) {
            System.out.printf("=".repeat(35)+"\nNAME: %s \n"+"=".repeat(35),p.getName());
        }
    }
}
