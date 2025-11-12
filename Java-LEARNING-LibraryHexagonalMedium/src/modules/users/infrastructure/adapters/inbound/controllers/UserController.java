package modules.users.infrastructure.adapters.inbound.controllers;


import modules.users.app.services.UserService;
import modules.users.domain.exceptions.models.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.models.UserInvalidException;
import modules.users.domain.exceptions.models.UsersNotFoundException;
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
            menu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllUsers();
                case "2"->searchUsers();
                case "3"->modifyUser();
                case "4"->{System.out.println("Exiting the User menu...");return;}
                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-4).");
            }
        }
    }

    /* @Override
    protected void searchUserOptions() {
        String option;
        while (true) {
            searchMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->searchUserById();
                case "2"->searchUsers();
                case "3"->{System.out.println("Exiting...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    } */

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
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void searchUserById(){
        String string=inCaseExit("Enter User ID: ");
        byte id;
        try {
            id=Byte.parseByte(string);
            service.findUser(id).stream().forEach(System.out::println);
        } catch (UsersNotFoundException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void modifyUser(){
        String ic;
        try {
            ic=inCaseExit("Enter your IC: ");
            boolean isEmpty=service.findUser(ic).isEmpty();
            if (isEmpty) {
                throw new UsersNotFoundException("User couldn't be found.");
            }
            // String ic=inCaseExit("Enter IC: ");
            String name=inCaseExit("Enter name: ");
            String lastname=inCaseExit("Enter lastname: ");
            String gender=inCaseExit("Enter a gender (M|F): ");
            String ageString=inCaseExit("Enter age: ");
            // ageString=(ageString.isBlank())?"0":ageString;
            Byte age=((ageString.isBlank())?null:Byte.parseByte(ageString));
            // age=Byte.parseByte(ageString);
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+
                "%nNAME: %s"+"\t\tLASTNAME: %s"+
                "%nGENDER: %s"+
                "%nAGE: %s"+
                "%n"+"=".repeat(12),
                ic,name,lastname,gender.toUpperCase(),ageString
            );
            System.out.println("\nIs anything ok (YES or CANCEL)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.modifyUser(ic, name, lastname, gender, age);
                System.out.println("-- User modified --");
                return;
            }else if(confirm.equalsIgnoreCase("CANCEL")){
                System.out.println("-- User NOT Modified --");
                return;
            }
            throw new UserCouldNotBeCreatedException("User couldn't be modified.");
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(UserInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
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
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
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
            // ageString=(ageString.isBlank())?"0":ageString;
            Byte age=((ageString.isBlank())?null:Byte.parseByte(ageString));
            // age=Byte.parseByte(ageString);
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+
                "%nNAME: %s"+"\t\tLASTNAME: %s"+
                "%nGENDER: %s"+
                "%nAGE: %s"+
                "%n"+"=".repeat(12),
                ic,name,lastname,gender.toUpperCase(),ageString
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
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(UserInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
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
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void rootOptions(){
        String option;
        while (true) {
            adminUserMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllUsers();
                case "2"->searchUsers();
                case "3"->createUser();
                case "4"->modifyUser();
                case "5"->deleteUser();
                case "6"->{System.out.println("Removing the admin privileges...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-6).");
            }
        }
    }
}
