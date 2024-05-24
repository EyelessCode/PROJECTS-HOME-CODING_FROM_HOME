package prueba.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("sumaFXML.fxml"));
        Scene ventana=new Scene(root);

        arg0.setTitle("SUMA #3");
        arg0.setScene(ventana);
        arg0.show();
    }
}
