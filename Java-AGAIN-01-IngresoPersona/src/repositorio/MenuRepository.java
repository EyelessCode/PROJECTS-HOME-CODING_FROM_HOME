package repositorio;

public class MenuRepository {
    public void menu(){
        System.out.println("=".repeat(35)+"MAIN MENU"+"=".repeat(35));
        System.out.println("1. INPUT");
        System.out.println("2. OUTPUT");
        System.out.println("3. EXIT");
        System.out.println("=".repeat(80));
    }

    public void miniMenuInput(){
        System.out.println("1. ADD A PERSON");
        System.out.println("2. EDIT A PERSON");
        System.out.println("3. DELETE A PERSON");
        System.out.println("4. GO BACK");
    }
}
