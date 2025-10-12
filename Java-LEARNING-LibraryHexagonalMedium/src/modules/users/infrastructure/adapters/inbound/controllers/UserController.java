package modules.users.infrastructure.adapters.inbound.controllers;


import modules.users.app.services.UserService;
import modules.users.domain.exceptions.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.UsersNotFoundException;
import modules.users.domain.ui.console.UserConsole;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;
import shared.exceptions.GenericNumberInvalidException;
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
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+
                "%nNAME: %s"+"\t\tLASTNAME: %s"+
                "%nGENDER: %s"+
                "%nAGE: %d"+
                "%n"+"=".repeat(12),
                ic,name,lastname,gender.toUpperCase(),age
            );
            System.out.println("\nIs anything ok (YES or CANCEL)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.createUser(ic, name, lastname, gender, age);
                System.out.println("-- User created --");
                return;
            }else if(confirm.equalsIgnoreCase("CANCEL")){
                System.out.println("-- User NOT created --");
                return;
            }
            throw new UserCouldNotBeCreatedException("User couldn't be created.");
        } catch (UserCouldNotBeCreatedException ex) {
            System.out.println("Error: "+ex.getMessage());
        }catch(GenericStringBoundaryException ex){
            System.out.println(ex.getMessage());
        }catch(GenericNumberInvalidException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void deleteUser(){
        System.out.println("\n-- REMOVING USER --");
        try {
            String ic=inCaseExit("Enter User's IC: ");
            var user=service.findUser(ic).get();
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+
                "%nNAME: %s"+"\t\tLASTNAME: %s"+
                "%nGENDER: %s"+
                "%nAGE: %d"+
                "%n"+"=".repeat(12),
                user.getIc().getValue(),user.getName().getValue(),user.getLastname().getValue(),user.getGender().getDescription(),user.getAge().getValue()
            );
            System.out.println("\nAre you sure to delete this User (YES or CANCEL)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.removeUser(ic);
                System.out.println("-- User deleted --");
                return;
            }else if(confirm.equalsIgnoreCase("CANCEL")){
                System.out.println("-- Deleting process canceled --");
                return;
            }
            throw new GenericStringBoundaryException("Unexpected response. Deletion process canceled.");
        } catch (UsersNotFoundException ex) {
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
                case "4"->deleteUser();
                case "5"->{System.out.println("Removing the admin privileges...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-5).");
            }
        }
    }
}
