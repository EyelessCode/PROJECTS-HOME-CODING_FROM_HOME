package test;

import java.util.Random;
import java.util.Scanner;

import entity.NumberFor;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        NumberFor n=new NumberFor(0, 0);
        Random r=new Random();

        n.setB(r.nextInt(1,3));
        n.setA(-1);

        System.out.println("1. ROCK\n"+"2. PAPER\n"+"3. SCISSOR\n"+"4. EXIT");
        while (n.getA()<1||n.getA()>4) {
            System.out.print("ENTER AN OPTION: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR INPUT. YOU CAN ONLY INPUT A NUMBER, NOT LETTER...\n"+"TRY IT AGAIN...");
                System.out.println("\n\n1. ROCK\n"+"2. PAPER\n"+"3. SCISSOR\n"+"4. EXIT");
                System.out.print("ENTER AN OPTION: ");
                scanner.nextLine();
            }
            n.setA(scanner.nextInt());
            scanner.nextLine();

            if (n.getA()<1||n.getA()>4) {
                System.out.println("INPUT A NUMBER BETWEEN 1 AND 4. TRY IT AGAIN...");
                System.out.println("\n\n1. ROCK\n"+"2. PAPER\n"+"3. SCISSOR\n"+"4. EXIT");
            }
        }
        n.getA();

        
        switch (n.getA()) {
            case 1:
                System.out.println("YOU PICKED 'ROCK'");

                if (n.getB()==n.getA()) {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println(">>>>> ¡DRAW! <<<<<");
                    break;
                }else if (n.getB()==2) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println(">>>>> ¡YOU LOSE! <<<<<");
                    break;
                }else if (n.getB()==3) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println(">>>>> ¡YOU WIN! <<<<<");
                    break;
                }
            case 2:
                System.out.println("YOU PICKED 'PAPER'");
    
                if (n.getB()==n.getA()) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println(">>>>> ¡DRAW! <<<<<");
                    break;
                }else if (n.getB()==1) {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println(">>>>> ¡YOU WIN! <<<<<");
                    break;
                }else if (n.getB()==3) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println(">>>>> ¡YOU LOSE! <<<<<");
                    break;
                }
            case 3:
                System.out.println("YOU PICKED 'SCISSOR'");
        
                if (n.getB()==n.getA()) {
                    System.out.println("MACHINE PICKED 'SCISSOR'");
                    System.out.println(">>>>> ¡DRAW! <<<<<");
                    break;
                }else if (n.getB()==1) {
                    System.out.println("MACHINE PICKED 'ROCK'");
                    System.out.println(">>>>> ¡YOU LOSE! <<<<<");
                    break;
                }else if (n.getB()==2) {
                    System.out.println("MACHINE PICKED 'PAPER'");
                    System.out.println(">>>>> ¡YOU WIN! <<<<<");
                    break;
                }
            case 4:
                scanner.close();
                break;
        }
            
    }
}
