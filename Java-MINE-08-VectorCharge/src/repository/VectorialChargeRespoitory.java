package repository;

import view.VectorView;

public class VectorialChargeRespoitory {
    private ValidationRepository validationRepository=new ValidationRepository();
    private VectorView vectorView = new VectorView();

    public void vectorFunction(){
        int vector[]=new int[15];

        vectorView.draw();
        for (int i = 0; i < vector.length; i++) {
            System.out.print("Enter a number: ");
            vector[i]=validationRepository.inputvalidation();
            System.out.printf("\nNumber: %s",vector[i]);
            System.out.println("\nYour in the turn "+i+"\n");
        }

        int sum = 0;
        for (int i = 0; i < vector.length; i++) {
            if(vector[i]%2==1){ // if the number is odd
                System.out.println("\nThe number "+vector[i]+" that you entered is odd");
            }else{
                System.out.println("\nThe number "+vector[i]+" that you entered is even");
            }

            if (vector[i]==3) {
                sum++;
            }
        }

        System.out.println("The number '3' is repeanting "+sum+" times!");
    }
}
