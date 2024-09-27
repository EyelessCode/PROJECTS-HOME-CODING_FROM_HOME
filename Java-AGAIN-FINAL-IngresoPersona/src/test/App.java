package test;

import entities.Person;
import repository.OptionRepository;
import repository.PersonRepository;

public class App {
    public static void main(String[] args) throws Exception {
        OptionRepository or=new OptionRepository();
        // PersonRepository pr=new PersonRepository();
        //// Person p=new Person();

        or.switchesMainMenu();
    }
}
