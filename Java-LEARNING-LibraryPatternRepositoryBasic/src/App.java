import controllers.LoanBookController;

public class App {
    public static void main(String[] args) throws Exception {
        LoanBookController lbc=new LoanBookController();
        lbc.run();
        System.out.println("Hello, World!");
    }
}
