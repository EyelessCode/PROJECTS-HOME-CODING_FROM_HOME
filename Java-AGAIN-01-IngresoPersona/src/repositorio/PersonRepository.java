package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Person;

public class PersonRepository {
    // private Person p;
    private List<Person> listPerson = new ArrayList<Person>();
    private Scanner scanner = new Scanner(System.in);
    // private MenuRepository mr;

    public void addPerson(Person p) {
        System.out.println("=".repeat(35) + "\nADDING A PERSON...\n" + "=".repeat(35));
        listPerson.add(p);
    }

    public void inputPerson(Person p) {
        System.out.println("=".repeat(75));
        System.out.println("|\n".repeat(2) + "\n¡READ THIS WITH CAREFUL!\nYOU CAN ONLY PUT A SENTENCE,"
                + "IF YOU TRY TO PUT A SPACE THE CONSOLE WILL FALL AND WILL APPEAR AN ERROR.\n");
        System.out.println("=".repeat(75));
        System.out.print("Enter name: ");
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
        // System.out.print("Enter Age: ");
        // while (!scanner.hasNextInt()) {
        //     System.out.println(
        //             "=".repeat(35) + "\nERROR OF FONT..." + "\nPUT A NUMBER NOT A LETTER...\n" + "=".repeat(35));
        //     System.out.print("Enter Age: ");
        //     scanner.nextLine();
        // }
        // p.setAge(scanner.nextInt());
        getValidateAge(); //? AGE ZONE


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

    public int getValidateAge(){
        int age=-1;
        boolean door=false;

        while (!door) {
            System.out.print("Enter Age: ");
            String convertion=scanner.nextLine();

            try {
                age=Integer.parseInt(convertion);

                if (age<=0) {
                    System.out.println(
                        "\n"+"=".repeat(20)+"\nAge cannot be negative."
                        +" Please enter a valid number...\n");
                    // scanner.next();
                } else if(age>120){
                    System.out.println(
                        "\n"+"=".repeat(20)+"\nThat's an unlikely age."
                    +" Please enter a realistic age...");
                    // scanner.next();
                }else {
                    door=true;
                    // scanner.next();
                }
            } catch (NumberFormatException nfe) {
                System.out.println(
                    "\n"+"=".repeat(20)+"\nPLEASE ENTER A VALID NUMBER."
                +" LETTERS OR SYMBOLS ARE NOT ALLOWED...");
                // scanner.next();
            }
        }
        return age;
    }

    public void removeAllPerson(Person p) {
        if (listPerson.isEmpty()) {
            System.out.println("There is no Person here...");
        } else {
            listPerson.removeAll(listPerson);
        }
        System.out.println("=".repeat(35) + "\nREMOVING ALL PERSON...\n" + "=".repeat(35));
    }

    public void removePersonByIc(String ic) {
        Person personRemove = null;

        for (Person person : listPerson) {
            if (person.getIc().equals(ic)) {
                personRemove = person;
                break;
            }
        }

        if (personRemove != null) {
            listPerson.remove(personRemove);
            System.out.println("Person with IC: " + ic + " has been removed...");
        } else {
            System.out.println("There's no person with " + ic + " here");
        }
    }

    // public void EditPerson(int id){
    // id=0;

    // for (Person person : listPerson) {
    // if (listPerson.get(id).equals(id)) {

    // break;
    // } else {

    // }
    // }
    // }

    public void showPerson() {
        if (listPerson.isEmpty()) {
            System.out.println("THERE ARE NO PERSONS HERE...");
        } else {
            for (Person p : listPerson) {
                System.out.printf("=".repeat(50) + "\nNAME: %s \tLAST NAME: %s \tGENRE: %s"
                        + "\tAGE: %d \tADDRESS: %s \nPHONE: %s \tEMAIL: %s"
                        + "\tPASSWORD: %s \tROLE: %s \tIC: %s \n" + "=".repeat(50),
                        p.getName(), p.getLastName(), p.getGenre(), p.getAge(), p.getAddress(),
                        p.getPhone(), p.getEmail(), p.getPassword(), p.getRole(), p.getIc());
            }
            
        }
    }

    public void showPersonIc() {
        if (listPerson.isEmpty()) {
            System.out.println("THERE'S NO IC PERSON HERE...");
        } else {
            for (Person p : listPerson) {
                System.out.printf("=".repeat(35) + "\nIC: %s \n" + "=".repeat(35), p.getIc());
            }
            
        }
    }

    public void showPersonName() {
        if (listPerson.isEmpty()) {
            System.out.println("THERE'S NO PERSON'S NAME HERE...");
        } else {
            for (Person p : listPerson) {
                System.out.printf("=".repeat(35) + "\nNAME: %s \n" + "=".repeat(35), p.getName());
            }
        }
    }

    public void showPersonEmails() {
        if (listPerson.isEmpty()) {
            System.out.println("THERE'S NO PERSON'S EMAILS HERE...");
        } else {
            for (Person p : listPerson) {
                System.out.printf("=".repeat(35) + "\nEMAILS: %s \n" + "=".repeat(35), p.getEmail());
            }
        }
    }
}
