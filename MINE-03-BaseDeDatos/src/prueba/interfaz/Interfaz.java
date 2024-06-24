package prueba.interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Interfaz extends Application{
    private Connection conexion;

    @Override
    public void start(Stage arg0) throws Exception {
        VBox vbox=new VBox();

        Label tituloPrincipal=creacionLabel("BIBLIOTECA", 18);
    }

    private Label creacionLabel(String texto,double fontSize){
        Label label=new Label(texto);
        label.setFont(Font.font(fontSize));
        label.setTextFill(Color.WHITE);
        return label;
    }

    private void baseDatos(){
        String url="jdbc:mysql://localhost:3306/biblioteca";
        String usuario="cristhian";
        String contrasenia="cris03022";

        try{
            conexion=DriverManager.getConnection(url, usuario, contrasenia);
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
