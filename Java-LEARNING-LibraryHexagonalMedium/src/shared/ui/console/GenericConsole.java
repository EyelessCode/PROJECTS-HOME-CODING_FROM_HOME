package shared.ui.console;

import java.util.Scanner;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

public class GenericConsole{
    private Scanner scanner=new Scanner(System.in);

    protected String inCaseExit(String message){
        System.out.print(message);
        String string=scanner.nextLine().trim();
        if ((string.equalsIgnoreCase("EXIT")||string.equalsIgnoreCase("LEAVE"))||(string.equalsIgnoreCase("X")||string.equalsIgnoreCase("ZZZ"))||(string.equalsIgnoreCase("BACK")||string.equalsIgnoreCase("GO BACK"))) {
            throw new GenericStringBoundaryException(
                "-- Cancelating process --"+
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
                System.out.println("Error: "+ex.getMessage());
            }
        }
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
