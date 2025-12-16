package modules.users.infrastructure.adapters.inbound.controllers;


import modules.users.app.services.UserService;
import modules.users.domain.exceptions.models.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.models.UsersNotFoundException;
import modules.users.domain.models.User;
import modules.users.domain.ui.console.UserConsole;
import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

import java.util.List;

public class UserController extends UserConsole{
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    public void userRun(){
        options();
    }
    public void userRootRun(){
        rootOptions();
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
                case "3"->{System.out.println("Going back to main Menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    private void showAllUsers(){
        try {
            List<User>users=service.findUsers();
            users.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+users.size()+" users registered.");
        } catch (UsersNotFoundException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void searchUserById(){
        String string=numberString("Enter User ID: ");
        byte id;
        try {
            id=Byte.parseByte(string);
            User user=service.findUser(id).get();
            System.out.println(user.toString());
        } catch (GenericStringBoundaryException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch (GenericNumberInvalidException ex) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (UsersNotFoundException ex) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }
    }

    private void modifyUser(){
        System.out.println("\n-- MODIFYING USER --");
        String ic;
        try {
            ic=numberString("Enter your IC: ");
            service.findUser(ic).get();
            String name=inCaseExit("Enter name: ");
            String lastname=inCaseExit("Enter lastname: ");
            String gender=inCaseExit("Enter a gender (M|F): ");
            String ageString=numberString("Enter age: ");
            Byte age=((ageString.isBlank())?null:Byte.parseByte(ageString));
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+"\tNAME: %s"+"\tLASTNAME: %s"+
                "%nGENDER: %s"+"\tAGE: %s"+
                "%n"+"=".repeat(12),
                ic,name,lastname,gender.toUpperCase(),ageString
            );
            System.out.println("\nIs anything ok (YES or NO)?");
            String confirm=inCaseExit("Enter: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.modifyUser(ic, name, lastname, gender, age);
                System.out.println("-- User modified --");
                return;
            }else if(confirm.equalsIgnoreCase("NO")){
                System.out.println("-- User NOT Modified --");
                return;
            }
            throw new GenericStringBoundaryException("User couldn't be modified.");
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(UsersNotFoundException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void searchUsers(){
        try {
            String string=inCaseExit("Enter User name, lastname or IC: ");
            List<User>users=service.findUsers(string);
            users.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+users.size()+" users found.");
        } catch (GenericStringBoundaryException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch (UsersNotFoundException ex) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: " + ex.getMessage() +
                    "\nCause: " + ex.getCause() +
                    "\nException: " + ex.getClass().getSimpleName() +
                    "\n" + ".".repeat(30)
            );
        }
    }

    private void createUser(){
        System.out.println("\n-- CREATING USER --");
        try {
            String ic=numberString("Enter IC: ");
            String name=inCaseExit("Enter name: ");
            String lastname=inCaseExit("Enter lastname: ");
            String gender=inCaseExit("Enter a gender (M|F): ");
            String ageString=numberString("Enter age: ");
            byte age=((ageString.isBlank())?0:Byte.parseByte(ageString));
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+"\tNAME: %s"+"\tLASTNAME: %s"+
                "%nGENDER: %s"+"\tAGE: %s"+
                "%n"+"=".repeat(12),
                ic,name,lastname,gender.toUpperCase(),ageString
            );
            System.out.println("\nIs anything ok (YES or NO)?");
            String confirm=inCaseExit("Enter: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.createUser(ic, name, lastname, gender, age);
                System.out.println("-- User created --");
                return;
            }else if(confirm.equalsIgnoreCase("NO")){
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
                "\n"+".".repeat(30)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(UserCouldNotBeCreatedException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void deleteUser(){
        System.out.println("\n-- REMOVING USER --");
        try {
            String ic=inCaseExit("Enter User's IC: ");
            User user=service.findUser(ic).get();
            System.out.printf(
                "%n"+"=".repeat(5)+" USER "+"=".repeat(5)+
                "%nIC: %s"+"\tNAME: %s"+"\tLASTNAME: %s"+
                "%nGENDER: %s"+"\tAGE: %d"+
                "%n"+"=".repeat(12),
                user.getIc().getValue(),user.getName().getValue(),user.getLastname().getValue(),
                user.getGender().getDescription(),user.getAge().getValue()
            );
            System.out.println("\nAre you sure to delete this User (YES or NO)?");
            String confirm=inCaseExit("Enter: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.removeUser(ic);
                System.out.println("-- User deleted --");
                return;
            }else if(confirm.equalsIgnoreCase("NO")){
                System.out.println("-- Deleting process canceled --");
                return;
            }
            throw new GenericStringBoundaryException("Unexpected response. Deletion process canceled.");
        } catch (GenericStringBoundaryException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(UsersNotFoundException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
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
                case "6"->{System.out.println("Going back to main Menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-6).");
            }
        }
    }
}
