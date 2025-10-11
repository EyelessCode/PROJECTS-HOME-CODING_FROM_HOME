package modules.users.infrastructure.adapters.inbound.controllers;


import modules.users.app.services.UserService;
import modules.users.domain.exceptions.UsersNotFoundException;
import modules.users.domain.ui.console.UserConsole;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

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
        byte option;
        while (true) {
            userMenu();
            option=fromInputOption();
            switch (option) {
                case 1->showAllUsers();
                case 2->searchUserOptions();
                case 3->throw new UnsupportedOperationException("Unimplemented method.");
                case 4->throw new UnsupportedOperationException("Unimplemented method.");
                case 5->{System.out.println("Exiting the User menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-5).");
            }
        }
    }

    @Override
    protected void searchUserOptions() {
        byte option;
        while (true) {
            searchUserMenu();
            option=fromInputOption();
            switch (option) {
                case 1->searchUserById();
                case 2->searchUsers();
                case 3->{System.out.println("Exiting...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    private void showAllUsers(){
        try {
            service.findUsers().forEach(users->System.out.printf(
                "%n[ ID: %d "+"-".repeat(3)+" Full name: %s %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Age: %d ]%n",
                users.getId().getValue(),
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
            service.findUserById(id).stream().forEach(System.out::println);
        } catch (UsersNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void searchUsers(){
        try {
            String string=inCaseExit("Enter User name, lastname or IC: ");
            service.findUsersByFullnameOrIc(string).forEach(users->System.out.printf(
                "%n[ ID: %d "+"-".repeat(3)+" Full name: %s %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Age: %d ]%n",
                users.getId().getValue(),
                users.getName().getValue(),
                users.getLastname().getValue(),
                users.getGender().getDescription(),
                users.getAge().getValue()
            ));
        } catch (UsersNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

}
