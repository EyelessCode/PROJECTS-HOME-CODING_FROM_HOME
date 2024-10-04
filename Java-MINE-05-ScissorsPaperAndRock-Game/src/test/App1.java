package test;

import java.util.Random;
import java.util.Scanner;

import entity.NumberFor;

public class App1 {
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        NumberFor n=new NumberFor(0, 0);
        Random r=new Random();

        n.setB(r.nextInt(1,3));
        n.setA(-1);

        
        while (n.getA()<1||n.getA()>3) {
            System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"-->: ");
            
            while (!sn.hasNextInt()) {
                sn.nextLine();
                System.out.print("1 = ROCK\n"+"2 = PAPER\n"+"3 = SCISSOR\n"+"-->: ");
            }
            
            n.setA(sn.nextInt());
            sn.nextLine();

            if (n.getA()==3) {
                System.out.println("YOU PICKED 'SCISSOR'");
                if (n.getB()==n.getA()) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println("DRAW!");
                }else if (n.getB()==2) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println("YOU WON!");
                }else {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println("YOU LOSE!");  
                }
            }else if (n.getA()==2) {
                System.out.println("YOU PICKED 'PAPER");
                if (n.getB()==3) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println("YOU LOSE!");
                }else if (n.getB()==n.getA()) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println("DRAW!");
                }else {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println("YOU WON!");
                }
            }else {
                System.out.println("YOU PICKED 'ROCK");
                if (n.getB()==3) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println("YOU WON!");
                }else if (n.getB()==2) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println("YOU LOSE!");
                }else {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println("DRAW!");
                }
            }
        }            

        sn.close();
    }
}
