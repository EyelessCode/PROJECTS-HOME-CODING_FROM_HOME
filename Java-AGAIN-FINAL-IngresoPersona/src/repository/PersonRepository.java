package repository;

import java.util.Scanner;

import entities.Person;

public class PersonRepository {
    // private Person pe=new Person();
    private Scanner scanner=new Scanner(System.in);

    //? INT METHODS
    // GET PERSON'S AGE
    public int ageInput(Person p){
        p.setAge(-1); // CENTINEL
        boolean door=false; // todo: THE DOOR WILL ALLOW THE CONDITIONS WORK

        while (!door) {
            System.out.print("\nENTER AN AGE: ");
            String input=scanner.nextLine(); // IT WILL WORKS FOR THE CONVERTION

            try {
                p.setAge(Integer.parseInt(input)); // MAKING THE CONVERTION

                if (p.getAge()<=0) {
                    System.out.println("PLEASE YOUR AGE CANNOT BE '0' OR A NEGATIVE NUMBER. PUT YOUR REAL AGE...");
                }else if (p.getAge()>120) {
                    System.out.println("PLEASE THAT'S AN IMPOSSIBLE AGE, PUT A REAL AGE...");
                }else {
                    door=true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("THAT'S NOT A NUMBER, PLEASE PUT A RIGHT INPUT...");
            }
        }
        return p.getAge();
    }

    //? STRING/CHAR METHODS
    // GET PERSON'S GENRE
    public char sexInput(Person p){
        p.setSex('\0');
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER YOUR SEX(F/M): ");
            String input=scanner.nextLine().toUpperCase();

            // todo: IT WORKS AS A CHARACTER LIMITER, YOU CAN ONLY PUT IN THE INPUT 'ONE CHARACTER' LIKE 'CHAR' VAR.
            if (input.length()==1&&(input.charAt(0)=='F'||input.charAt(0)=='M')) {
                p.setSex(input.charAt(0));
                door=true;
            }else{
                System.out.println("PLEASE, YOU CAN ONLY PUT 'F' (FEMALE) OR 'M' (MALE), TRY IT AGAIN...");
            }
        }
        return p.getSex();
    }

    public String nameInput(Person p){
        p.setName(null);
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER A NAME: ");
            String input=scanner.next();

            if (input.length()<=15) {
                p.setName(input.toUpperCase());
                door=true;
            }else{
                System.out.println("PLEASE, WE CAN ONLY GET 15 CHARACTERS. TRY IT AGAIN...");
            }
        }
        scanner.nextLine();
        return p.getName();
    }

    public String lastnameInput(Person p){
        p.setLastname(null);
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER A LASTNAME: ");
            String input=scanner.next();

            if (input.length()<=15) {
                p.setLastname(input.toUpperCase());
                door=true;
            }else{
                System.out.println("PLEASE, WE CAN ONLY GET 15 CHARACTERS. TRY IT AGAIN...");
            }
        }
        scanner.nextLine();
        return p.getLastname();
    }

    public String rolInput(Person p){
        p.setRol(null);
        boolean door=false;

        while (!door) {
            System.out.print(
                "\n"+"=".repeat(15)+"\nROLS:\tNOOB\tBEGINNER\tBORN\n"+"=".repeat(15)+"\n");
            System.out.print("\nENTER A ROL: ");
            String input=scanner.next().toUpperCase();

            if (input.contains("BORN")||input.contains("NOOB")||input.contains("BEGINNER")) {
                p.setRol(input);
                door=true;
            }else{
                System.out.println("PLEASE, INPUT ANY ROLE. YOU CANNOT CONTINUE WITHOUT A ROLE. TRY IT AGAIN...");
            }
        }
        // scanner.nextLine();
        return p.getRol();
    }

    public String icInput(Person p){
        p.setIc(null);
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER AN IC: ");
            String input=scanner.nextLine();

            if (input.length()==10){
                p.setIc(input);

                if (input.startsWith("09")) {
                    p.setIc(input);
                }
                door=true;
            }else{
                System.out.println("PLEASE TRY TO PUT YOUR IC, TRY IT AGAIN...");
            }
        }
        return p.getIc();
    }
}
