package prueba.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource(""));
        Scene ventana=new Scene(root);

        arg0.setTitle("CALCULADORA FINAL DE SUMA SIMPLE");
        arg0.setScene(ventana);
        arg0.show();
    }
}
