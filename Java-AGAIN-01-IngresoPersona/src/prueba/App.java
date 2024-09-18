package prueba;

import repositorio.MenuRepository;

public class App {
    public static void main(String[] args) throws Exception {
        MenuRepository mr = new MenuRepository();
        System.out.println("Hello, World!");

        mr.switchesMain();
    }
}
