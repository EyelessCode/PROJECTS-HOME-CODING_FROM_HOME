import java.util.Random;
import java.util.Scanner;

import entity.NumberFor;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sn=new Scanner(System.in);
        NumberFor nf=new NumberFor(0, 0);
        Random r=new Random();
        boolean door=false;

        nf.setA(r.nextInt(1,3));
        nf.setB(r.nextInt(1,3));

        System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"→: ");
        
        while (!sn.hasNextInt()) {
            System.out.println("JUST NUMBERS NOT LETTERS OR SOMETHING ELSE...");
            sn.nextLine();
        }
        int input=sn.nextInt();
        sn.nextLine();

            
        if (input<=3||input>=1) {
            if (input==3) { //
                System.out.println("YOU PICKED 'SCISSOR'");
                if (nf.getA()==input) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nDRAW!");
                }else if (nf.getA()==2) {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU WON!");
                }else{
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU LOSE!");
                }
            }else if (input==2) { //
                System.out.println("YOU PICKED 'PAPER'");
                if (nf.getA()==input) {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nDRAW!");
                }else if (nf.getA()==3) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU LOSE!");
                }else{
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU WON!");
                }
            }else { //
                System.out.println("YOU PICKED 'ROCK'");
                if (nf.getA()==input) {
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nDRAW!");
                }else if (nf.getA()==3) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU WON!");
                }else {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU LOSE!");
                }
            }
            
        }else{
            System.out.println("INPUT A NUMBER BETWEEN 1 AND 3...");
        }

            
    }
}
