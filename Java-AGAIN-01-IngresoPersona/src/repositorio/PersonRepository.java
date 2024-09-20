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
        // System.out.print("Enter Genre: ");
        // p.setGenre(scanner.next().toUpperCase().charAt(0));
        getValidateGenre(p); //? GENRE ZONE
        // scanner.nextLine();
        // System.out.print("Enter Age: ");
        // while (!scanner.hasNextInt()) {
        //     System.out.println(
        //             "=".repeat(35) + "\nERROR OF FONT..." + "\nPUT A NUMBER NOT A LETTER...\n" + "=".repeat(35));
        //     System.out.print("Enter Age: ");
        //     scanner.nextLine();
        // }
        // p.setAge(scanner.nextInt());
        getValidateAge(p); //? AGE ZONE


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

    public int getValidateAge(Person p){
        p.setAge(-1);
        boolean door=false;

        while (!door) {
            System.out.print("Enter Age: ");
            String convertion=scanner.nextLine();

            try {
                p.setAge(Integer.parseInt(convertion));

                if (p.getAge()<=0) {
                    System.out.println(
                        "\n"+"=".repeat(20)+"\nAge cannot be negative."
                        +" Please enter a valid number...\n");
                    // scanner.next();
                } else if(p.getAge()>120){
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
        
        return p.getAge();
    }

    public char getValidateGenre(Person p){
        p.setGenre('\0');
        boolean door=false;

        while (!door) {
            System.out.print("Enter Genre (F/M): ");
            String input=scanner.nextLine().toUpperCase();

            if (input.length()==1&&(input.charAt(0)=='M'||input.charAt(0)=='F')) {
                p.setGenre(input.charAt(0));
                door=true;
            } else {
                System.out.println("INVALID INPUT. PLEASE ENTER 'M' FOR MALE OR 'F' FOR FEMALE...");
            }
        }
        return p.getGenre();
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

    public void EditPerson(String ic){
        Person edit=null;
        
        for (Person p : listPerson) {
            if (p.getIc().equals(ic)) {
                edit=p;
                break;
            }
        }

        if (edit!=null) {
            System.out.println("PERSON FOUND WITH IC: "+ic+"\n");
            System.out.println("=".repeat(30)+"\nEDITING PERSON...\n"+"=".repeat(30)+"\n");
        
            //? NAME
            System.out.print("ENTER A NEW NAME (OR PRESS ENTER TO KEEP CURRENT: "+edit.getName()+"): ");
            String name=scanner.nextLine().toUpperCase();
            // scanner.next();
            if (!name.isEmpty()) {
                edit.setName(name);
            }
            
            //? LASTNAME
            System.out.print("ENTER A NEW LASTNAME (OR PRESS ENTER TO KEEP CURRENT: "+edit.getLastName()+"): ");
            String lastName=scanner.nextLine();
            // scanner.nextLine();
            if (!lastName.isEmpty()) {
                edit.setLastName(lastName);
            }

            // //? GENRE
            // System.out.print("ENTER A NEW GENRE (F/M) (OR PRESS ENTER TO KEEP CURRENT: "+edit.getGenre()+")");
            // String genre=scanner.nextLine();
            // if(!genre.isEmpty()&&(genre.charAt(0)=='M'||genre.charAt(0)=='F')){
            //     edit.setGenre(genre.charAt(0));
            // }
            
            //? AGE
            System.out.print("ENTER A NEW AGE (OR PRESS ENTER TO KEEP CURRENT: '"+edit.getAge()+"'): ");
            String age=scanner.nextLine();
            // scanner.nextLine(); //! NEXT TO THIS SCANNER THERE'S A SCANNER.NEXTLINE()
                                    //! FOR THAT THIS SCANNER WE DON'T NEED IT
            if (!age.isEmpty()) {
                try{
                    int ageConvertion=Integer.parseInt(age);
                    edit.setAge(ageConvertion);
                    if (ageConvertion>0&&ageConvertion<=120) {
                        edit.setAge(ageConvertion);
                    } else {
                        System.out.println("INVALID AGE, KEEPING CURENT VALUE...");
                    }
                }catch(NumberFormatException nfe){
                    System.out.println("INVALID AGE, KEEPING CURRENT: "+edit.getAge());
                }
            }
            //? GENRE
            System.out.print("ENTER A NEW GENRE (F/M) (OR PRESS ENTER TO KEEP CURRENT: '"+edit.getGenre()+"'): ");
            String genre=scanner.nextLine();
            // scanner.nextLine();
            if(!genre.isEmpty()&&(genre.charAt(0)=='M'||genre.charAt(0)=='F')){
                edit.setGenre(genre.charAt(0));
            }

            //? ADDRESS
            System.out.print("ENTER A NEW ADDRESS (OR PRESS ENTER TO KEEP CURRENT: "+edit.getAddress()+"): ");
            String address=scanner.nextLine(); //! SCANNER.NEXTLINE()
            if (!address.isEmpty()) {
                edit.setAddress(address);
            }

            //? PHONE
            System.out.print("ENTER A NEW PHONE (OR PRESS ENTER TO KEEP CURRENT: "+edit.getPhone()+"): ");
            String phone=scanner.nextLine();
            if (!phone.isEmpty()) {
                edit.setPhone(phone);
            }

            //? EMAIL
            System.out.print("ENTER A NEW EMAIL (OR PRESS ENTER TO KEEP CURRENT: "+edit.getEmail()+"): ");
            String email=scanner.nextLine();
            if (!email.isEmpty()) {
                edit.setEmail(email);
            }

            //? ROL
            System.out.print("ENTER A NEW ROL (OR PRESS ENTER TO KEEP CURRENT: "+edit.getRole()+"): ");
            String rol=scanner.nextLine();
            // scanner.nextLine();
            if (!rol.isEmpty()) {
                edit.setRole(rol);
            }
            
            System.out.println("PERSON UPDATED SUCCESSFULLY!");

        }else{
            System.out.println("PERSON WITH IC: "+ic+" NOT FOUND...");
        }
    }

    public void showPerson() {
        if (listPerson.isEmpty()) {
            System.out.println("THERE ARE NO PERSONS HERE...");
        } else {
            for (Person p : listPerson) {
                System.out.printf("=".repeat(50) + "\nNAME: %s \tLASTNAME: %s \tGENRE: %s"
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
