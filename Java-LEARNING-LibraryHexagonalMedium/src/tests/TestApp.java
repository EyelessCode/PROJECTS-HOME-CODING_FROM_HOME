package tests;


import modules.users.domain.models.User;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("=".repeat(20));
            User u=new User((byte)1, "XXX", "CRIS", "GUED", 'f', (byte)22);
            System.out.println(u.toString());
        System.out.println("=".repeat(20));
    }
}
