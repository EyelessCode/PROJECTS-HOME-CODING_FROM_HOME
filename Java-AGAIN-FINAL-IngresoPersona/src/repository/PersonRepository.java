package repository;

import java.util.Scanner;

import entities.Person;

public class PersonRepository {
    // private Person pe=new Person();
    private Scanner scanner=new Scanner(System.in);

    //? AGE METHOD
    // INPUT A PERSON
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
                }
            } catch (NumberFormatException nfe) {
                System.out.println("THAT'S NOT A NUMBER, PLEASE PUT A RIGHT INPUT...");
            }
        }
        return p.getAge();
    }

    public char sexInput(Person p){
        p.setSex('\0');
        boolean door=false;

        while (!door) {
            System.out.print("ENTER YOUR SEX(F/M): ");
            String input=scanner.nextLine();

            // todo: IT WORKS AS A CHARACTER LIMITER, YOU CAN ONLY PUT IN THE INPUT 'ONE CHARACTER' LIKE 'CHAR' VAR.
            if (input.length()==1&&(input.charAt(0)=='F'||input.charAt(0)=='M')) {
                p.setSex(input.toUpperCase().charAt(0));
                door=true;
            }else{
                System.out.println("PLEASE, YOU CAN ONLY PUT 'F' (FEMALE) OR 'M' (MALE), TRY IT AGAIN...");
            }
        }
        return p.getSex();
    }
}
