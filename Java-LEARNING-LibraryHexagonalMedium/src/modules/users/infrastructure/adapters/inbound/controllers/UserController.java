package modules.users.infrastructure.adapters.inbound.controllers;


import modules.users.app.services.UserService;
import modules.users.domain.exceptions.UserCouldNotBeCreated;
import modules.users.domain.exceptions.UsersNotFoundException;
import modules.users.domain.ui.console.UserConsole;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;
import shared.exceptions.GenericStringBoundaryException;

public class UserController extends UserConsole{
    private UserService service;

    public UserController(){
        UserRepositoryInMemory repository=new UserRepositoryInMemory();
        this.service=new UserService(repository);
    }

    public void userRun(){
        options();
    }

    @Override
    protected void options() {
        String option;
        while (true) {
            userMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllUsers();
                case "2"->searchUserOptions();
                case "3"->{System.out.println("Exiting the User menu...");return;}
                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    @Override
    protected void searchUserOptions() {
        String option;
        while (true) {
            searchUserMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->searchUserById();
                case "2"->searchUsers();
                case "3"->{System.out.println("Exiting...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    private void showAllUsers(){
        try {
            service.findUsers().forEach(users->System.out.printf(
                "%n[ IC: %s "+"-".repeat(3)+" Full name: %s %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Age: %d ]%n",
                users.getIc().getValue(),
                users.getName().getValue(),
                users.getLastname().getValue(),
                users.getGender().getDescription(),
                users.getAge().getValue()
            ));
        } catch (UsersNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void searchUserById(){
        String string=inCaseExit("Enter User ID: ");
        byte id;
        try {
            id=Byte.parseByte(string);
            service.findUser(id).stream().forEach(System.out::println);
        } catch (UsersNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void searchUsers(){
        try {
            String string=inCaseExit("Enter User name, lastname or IC: ");
            service.findUsers(string).forEach(users->System.out.printf(
                "%n[ IC: %s "+"-".repeat(3)+" Full name: %s %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Age: %d ]%n",
                users.getIc().getValue(),
                users.getName().getValue(),
                users.getLastname().getValue(),
                users.getGender().getDescription(),
                users.getAge().getValue()
            ));
        } catch (UsersNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void createUser(){
        System.out.println("\n-- CREATING USER --");
        try {
            String ic=inCaseExit("Enter IC: ");
            String name=inCaseExit("Enter name: ");
            String lastname=inCaseExit("Enter lastname: ");
            String gender=inCaseExit("Enter a gender (M|F): ");
            String ageString=inCaseExit("Enter age: ");
            byte age=Byte.parseByte(ageString);
            service.createUser(ic, name, lastname, gender, age);
        } catch (UserCouldNotBeCreated ex) {
            System.out.println("Error: "+ex.getMessage());
        }catch(GenericStringBoundaryException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void rootOptions(){
        String option;
        while (true) {
            adminUserMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllUsers();
                case "2"->searchUserOptions();
                case "3"->createUser();
                case "4"->throw new UnsupportedOperationException("Unimplemented method.");
                case "5"->{System.out.println("Removing the admin privileges...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-5).");
            }
        }
    }
}
