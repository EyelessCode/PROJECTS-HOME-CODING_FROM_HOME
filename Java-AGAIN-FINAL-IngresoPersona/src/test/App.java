package test;

import entities.Person;
import repository.OptionRepository;

public class App {
    public static void main(String[] args) throws Exception {
        OptionRepository or=new OptionRepository();
        Person p=new Person();

        or.switchesMainMenu(p);        
    }
}
