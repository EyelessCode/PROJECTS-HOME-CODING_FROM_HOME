import shared.infrastructure.adapters.inbound.controllers.SharedController;
import shared.infrastructure.datas.seeders.Seeder;

public class App {
    public static void main(String[] args) throws Exception {
        Seeder seeder=new Seeder();
        seeder.load();
        SharedController controller=new SharedController();
        controller.run();
    }
}
