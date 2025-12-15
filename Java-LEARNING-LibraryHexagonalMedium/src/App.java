import shared.infrastructure.AppContext;
import shared.infrastructure.adapters.inbound.controllers.SharedController;

public class App {
    public static void main(String[] args) throws Exception {
        SharedController app=AppContext.build();
        app.run();
    }
}
