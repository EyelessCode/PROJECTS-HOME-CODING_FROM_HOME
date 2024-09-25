package test;

import entities.Person;
import interfaces.PersonInterface;
import repository.OptionRepository;
import repository.PersonRepository;

public class App {
    public static void main(String[] args) throws Exception {
        // OptionRepository or=new OptionRepository();
        PersonRepository pr=new PersonRepository();
        PersonInterface pi=new PersonInterface();
        Person p=new Person();

        // or.switchesMainMenu(p);
        pr.passwordInput(p); 
        pr.ageInput(p);
        pr.listCompletely();
    }
}
