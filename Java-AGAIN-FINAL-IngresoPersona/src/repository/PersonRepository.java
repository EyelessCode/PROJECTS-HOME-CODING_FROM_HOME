package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Person;

public class PersonRepository {
    private List<Person>lp=new ArrayList<Person>();
    private Scanner scanner=new Scanner(System.in);
    private Person p=new Person();

    //? INPUT METHODS ---------------------------------------------------

    //? INT METHODS ----------------------------------------------

    // GET PERSON'S AGE
    public int ageInput(Person p){
        p.setAge(-1); // SENTINEL
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
    
    // GET PERSON'S PASSWORD
    public int passwordInput(Person p){
        p.setPassword(-1); // SENTINEL
        boolean door=false;
        
        while (!door) {
            System.out.print("\nENTER A PASSWORD: ");
            String input=scanner.nextLine(); // IT WILL WORKS FOR THE CONVERTION
            
            try {
                if (input.length()==5) {
                    p.setPassword(Integer.parseInt(input));
                    door=true;
                }else{
                    System.out.println("INPUT ERROR. PLEASE INPUT ONLY 5 DIGITS...");
                }
                
            } catch (NumberFormatException nfe) {
                System.out.println("THAT'S NOT A NUMBER, PLEASE PUT A RIGHT INPUT...");
            }
        }

        return p.getPassword();
    }

    //? STRING/CHAR METHODS -------------------------------------------

    // GET PERSON'S GENRE
    public char sexInput(Person p){
        p.setSex('\0');
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER YOUR SEX (F/M): ");
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

    // GET PERSON'S NAME
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

    // GET PERSON'S LASTNAME
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

    // GET PERSON'S ROLE
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

        scanner.nextLine();
        return p.getRol();
    }

    // GET PERSON'S IC
    public String icInput(Person p){
        p.setIc(null);
        boolean door=false;

        while (!door) {
            System.out.print("\nENTER AN IC: ");
            String input=scanner.nextLine();

            if (input.startsWith("09")) {
                p.setIc(input);

                if (input.length()==10){
                    p.setIc(input);
                    door=true;
                }else{
                    System.out.println("PLEASE TRY TO PUT YOUR IC, TRY IT AGAIN...");

                }
            }else{
                System.out.println("IC STARTS WITH '09'. TRY IT AGAIN...");
            }
        }

        return p.getIc();
    }

    //? CONSOLE PRINT ---------------------------------------------------

    //! NO ADMIN
    // ADD A PERSON
    public void addPerson(Person p){
        System.out.println("GETTING A NEW PERSON...");
        lp.add(new Person(p.getName(),p.getLastname(),p.getIc(),p.getSex(),p.getAge(),p.getRol(),p.getPassword()));
    }

    //! ADMIN
    // SHOW ENTIRE LIST
    public void listCompletely(){
        // todo: I HAVE BEEN TESTING SOMETHING, FOR NOW THESE WILL BE COMMENTED
        for (Person p : lp) {
            System.out.printf("\n"+"=".repeat(70)+"\nNAME: %s \t\tLASTNAME: %s\t\tIC: %s"
            +"\nSEX: %s \t\tAGE: %d \t\tROL: %s \n"+"=".repeat(70)+"\n", p.getName(),p.getLastname(),p.getIc(),p.getSex(),p.getAge(),p.getRol());
        }
    }

    //! ADMIN
    // SHOW ONLY NAMES
    public void showNamesAndLastnames(){
        for (int i = 0; i < lp.size(); i++) {
            Person p=lp.get(i);
            System.out.printf("\n"+"=".repeat(50)+"\n-> "+i+"\tNAME: %s \t\tLASTNAME: %s \n"+"=".repeat(50)+"\n", p.getName(), p.getLastname());
        }
    }
    
    //! ADMIN
    // SHOW ONLY IC
    public void showIc(){
        for (int i = 0; i < lp.size(); i++) {
            Person p=lp.get(i);
            System.out.printf("\n"+"=".repeat(50)+"\n-> "+i+"\tNAME: %s \n"+"=".repeat(50)+"\n", p.getIc());
        }
    }

    //! ADMIN
    // DELETE ENTIRE LIST
    public void deleteList(){
        System.out.println("DELETING PERSONS LIST...");
        lp.clear();
    }

    // DELETE THE FIRST REGISTRATION
    public void deleteFirst(){
        if (!lp.isEmpty()) {
            lp.remove(0);
        }else {
            System.out.println("DELETING THE LAST REGISTRATION...");
        }
    }

    //! ADMIN
    // DELETE A PERSON BY SEARCHING
    public void deleteBySearch(String ic){
        boolean door= true;
        while (door) {
            System.out.println("=".repeat(15)+"INPUT PERSON'S IC YOU WANT TO DELETE"+"=".repeat(15));
            Person removePerson=null;
    
            for (Person person : lp) {
                if (person.getIc().equals(ic)) {
                    removePerson=person;
                    break;
                }
            }

            if (removePerson!=null) {
                if (getPasswordDelete()==removePerson.getPassword()) {
                    lp.remove(removePerson);
                    door=false;
                    System.out.println("THE PERSON WITH "+ic+" HAS BEEN DELETED.");
                }else{
                    System.out.println("INCORRECT PASSWORD. INPUT A RIGHT PASSWORD. TRY IT AGAIN...");
                }
            }else{
                System.out.println("THERE'S NO PERSON WITH "+ic+" YET. TRY IT AGAIN...");
            }  
        }
     
        //// scanner.nextLine();
        /*
        // while (!door) {
        //     System.out.print("\nBEFORE TO DELETE SOMEONE, WE NEED HIS/HER PASSWORD. PLEASE ENTER PASSWORD: ");
        //     passwordInput=scanner.nextInt();
            
        //     while (passwordInput!=p.getPassword()) {
        //         System.out.println("INCORRECT PASSWORD. INPUT A RIGHT PASSWORD. TRY IT AGAIN...");
        //         for (Person p : lp) {
        //             if (passwordInput==p.getPassword()) {
        //                 break;
        //             }else{
        //                 System.out.println("INCORRECT PASSWORD. INPUT A RIGHT PASSWORD. TRY IT AGAIN...");
        //                 break;
        //             }
    
        //         }
        //     } 
         */
            
            /*
            // while (!scanner.hasNextInt()) {
            //     System.out.println("PLEASE INPUT NUMBERS NOT A LETTERS. TRY IT AGAIN...");
            //     scanner.nextLine();
            // }
             */

            // IC
        //// }
    }
    //! ADMIN
    // COMPLEMENT AT PASSWORD DELETE BY DELETED A PERSON BY SEARCHING
    //? ↑↑↑↑
    public int getPasswordDelete(){
        //// scanner.nextLine();
        Person passwordPerson = null;
        boolean door = false;
        int passwordRemove = -1;
        
        while (!door) {

            System.out.print("\nBEFORE TO DELETE SOMEONE, WE NEED HIS/HER PASSWORD. PLEASE ENTER PASSWORD: ");
            if (scanner.hasNextInt()) {
                passwordRemove = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer
    
                for (Person person : lp) {
                    if (passwordRemove == person.getPassword()) {
                        passwordPerson = person;
                        door = true;
                        break;
                    }
                }
    
                if (!door) {
                    System.out.println("INCORRECT PASSWORD. INPUT A RIGHT PASSWORD. TRY IT AGAIN...");
                }
            } else {
                System.out.println("PLEASE INPUT NUMBERS NOT LETTERS. TRY IT AGAIN...");
                scanner.nextLine(); // Limpia el buffer incorrecto
            }
        }
        return passwordRemove;
    }

    //! DELETE BY SEARCH    -   IT'S A COMPLEMENT TO GET PERSON'S IC TO REMOVE
    public String getIcRemove(){
        String icRemove=null;
        boolean door=true;
        
        while (door) {
            System.out.print("ENTER PERSON'S IC TO DELETE: ");
            icRemove=scanner.nextLine();

            if (icRemove.length()==10) {
                door=false;
            }else{
                System.out.println("IC DOESN'T EXIST. EACH PERSON'S IC HAS 10 DIGITS. TRY IT AGAIN...");
            }

        }
        
        
        //// scanner.nextLine();
        return icRemove;
    }

    //! ---------------------------------------------------------------

    //? MOST METHODS
    public void personData(Person p){
        nameInput(p); // NAME
        lastnameInput(p); // LASTNAME
        icInput(p); // IC
        sexInput(p); // SEX
        ageInput(p); // AGE
        rolInput(p); // ROLE
        passwordInput(p); // PASSWORD

        addPerson(p); // ADD A PERSON
    }
}
