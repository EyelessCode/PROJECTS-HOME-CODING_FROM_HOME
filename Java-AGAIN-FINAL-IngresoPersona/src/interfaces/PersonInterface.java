package interfaces;

import java.util.ArrayList;
import java.util.List;

import entities.Person;

public class PersonInterface {
    private List<Person>lp=new ArrayList<Person>();

    //? ENTIRE LIST
    public void listCompletely(Person pe){
        for (Person p : lp) {
            System.out.printf("\nNAME: %s \t\tLASTNAME: %s\t\tIC: %s"
            +"\nSEX: %s \t\tAGE: %d \t\tROL: %s", p.getName(),p.getLastname(),p.getIc(),p.getSex(),p.getAge(),p.getRol());
        }
    }
}
