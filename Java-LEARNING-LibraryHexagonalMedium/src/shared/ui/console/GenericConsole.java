package shared.ui.console;

import java.util.Scanner;

import shared.exceptions.GenericStringBoundaryException;

public class GenericConsole{
    private Scanner scanner=new Scanner(System.in);

    protected String inCaseExit(String message){
        System.out.print(message);
        String string=scanner.nextLine().trim();
        if ((string.equalsIgnoreCase("EXIT")||string.equalsIgnoreCase("LEAVE"))||(string.equalsIgnoreCase("X")||string.equalsIgnoreCase("GO BACK"))) {
            throw new GenericStringBoundaryException("Cancelating process..."+"\nGoing back...");
        }
        return string;
    }

    protected byte fromInputOption(){
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
    }
}
