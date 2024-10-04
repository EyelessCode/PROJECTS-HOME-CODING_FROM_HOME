import java.util.Random;
import java.util.Scanner;

import entity.NumberFor;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sn=new Scanner(System.in);
        NumberFor nf=new NumberFor(0, 0);
        Random r=new Random();

        nf.setB(r.nextInt(1,3));

        System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"-->: ");
        
        while (!sn.hasNextInt()) {
            System.out.println("JUST NUMBERS NOT LETTERS OR SOMETHING ELSE...");
            System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"-->: ");
            sn.nextLine();
        }
        nf.setA(sn.nextInt());
        sn.nextLine();

            
        if (nf.getA()<=3||nf.getA()>=1) {
            if (nf.getA()==3) { //
                System.out.println("YOU PICKED 'SCISSOR'");
                if (nf.getB()==nf.getA()) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nDRAW!");
                }else if (nf.getB()==2) {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU WON!");
                }else{
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU LOSE!");
                }
            }else if (nf.getA()==2) { //
                System.out.println("YOU PICKED 'PAPER'");
                if (nf.getB()==nf.getA()) {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nDRAW!");
                }else if (nf.getB()==3) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU LOSE!");
                }else{
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU WON!");
                }
            }else { //
                System.out.println("YOU PICKED 'ROCK'");
                if (nf.getB()==nf.getA()) {
                    System.out.println("MACHINE PULLS 'ROCK'"+"\nDRAW!");
                }else if (nf.getB()==3) {
                    System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU WON!");
                }else {
                    System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU LOSE!");
                }
            }
            
        }else{
            System.out.println("INPUT A NUMBER BETWEEN 1 AND 3...");
        }

        sn.close();
    }
}
