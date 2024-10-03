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

        while (!door) {
            System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"→: ");
            int input=sn.nextInt();
            sn.nextLine();

            while (!sn.hasNextInt()) {
                System.out.println("JUST NUMBERS NOT LETTERS OR SOMETHING ELSE...");
                sn.nextLine();
            }

            
            if (input<=3||input>=1) {
                if (input==3) { //
                    System.out.println("YOU PICKED 'SCISSOR'");
                    if (nf.getA()==input) {
                        System.out.println("MACHINE PULLS 'SCISSOR'"+"\nDRAW!");
                        break;
                    }else if (nf.getA()==2) {
                        System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU WON!");
                        break;
                    }else{
                        System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU LOSE!");
                        break;
                    }
                }else if (input==2) { //
                    System.out.println("YOU PICKED 'PAPER'");
                    if (nf.getA()==input) {
                        System.out.println("MACHINE PULLS 'PAPER'"+"\nDRAW!");
                        break;
                    }else if (nf.getA()==3) {
                        System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU LOSE!");
                        break;
                    }else{
                        System.out.println("MACHINE PULLS 'ROCK'"+"\nYOU WON!");
                        break;
                    }
                }else { //
                    System.out.println("YOU PICKED 'ROCK'");
                    if (nf.getA()==input) {
                        System.out.println("MACHINE PULLS 'ROCK'"+"\nDRAW!");
                        break;
                    }else if (nf.getA()==3) {
                        System.out.println("MACHINE PULLS 'SCISSOR'"+"\nYOU WON!");
                        break;
                    }else {
                        System.out.println("MACHINE PULLS 'PAPER'"+"\nYOU LOSE!");
                        break;
                    }
                }
                
            }else{
                System.out.println("INPUT A NUMBER BETWEEN 1 AND 3...");
            }

            
        }
    }
}
