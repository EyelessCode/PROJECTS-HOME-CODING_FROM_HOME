package shared.ui.console;

import java.util.Scanner;

import modules.books.domain.exceptions.models.BookInvalidException;
import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

public class GenericConsole{
    private final Scanner scanner=new Scanner(System.in);

    protected String inCaseExit(String message){
        System.out.print(message);
        String string=scanner.nextLine().trim();
        if ((string.equalsIgnoreCase("EXIT")||string.equalsIgnoreCase("LEAVE"))||
                (string.equalsIgnoreCase("X")||string.equalsIgnoreCase("ZZZ"))||
                (string.equalsIgnoreCase("BACK")||string.equalsIgnoreCase("GO BACK"))||
                (string.equalsIgnoreCase("NOP"))) {
            throw new GenericStringBoundaryException(
                "-- Cancelling process --"+
                "\n<<<--- Going back... --->>>"
            );
        }
        return string;
    }

    protected String fromInputOption(){
        String string;
        while (true) {
            try {
                // We don't need 'inCaseExit' method.
                System.out.print("Enter an option -->: ");
                string=scanner.nextLine();
                return string;
            } catch (GenericNumberInvalidException ex) {
                System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
                );
            }
        }
    }

    protected String numbeString(String message){
        String string;
        try {
            System.out.print(message);
            string=scanner.nextLine();
            if (string.matches("^\\d+$")||string.isEmpty()){
                return string;
            }

        } catch (BookInvalidException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
        //! I need to delete this, i just want to return a String, but this fucking thing wants another return
        return null;
    }

    //? Original
    /* protected byte fromInputOption(){
        String string;
        byte option;
        while (true) {
            string=inCaseExit("Enter an option -->: ");
            // string=scanner.nextLine();
            try {
                option=Byte.parseByte(string);
                if (option>0) {
                    return option;
                }
                return -1;
            } catch (NumberFormatException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
    } */
}
