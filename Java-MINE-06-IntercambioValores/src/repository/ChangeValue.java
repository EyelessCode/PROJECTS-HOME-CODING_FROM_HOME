package repository;

public class ChangeValue {
    public void change(){
        int x=35;
        int z=20;
        System.out.println("Values Before the change: "+x+" and "+z);
        int temp=x;
        x=z;
        z=temp;
        System.out.println("Values After the change: "+x+" and "+temp);
        // That wasn't hard
    }
}
