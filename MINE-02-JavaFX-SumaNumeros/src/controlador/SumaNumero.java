package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import modelo.Suma;

public class SumaNumero {

    @FXML
    private Button btnSumar;

    @FXML
    private TextField txtOp1;

    @FXML
    private TextField txtOp2;

    @FXML
    private TextField txtResultado;

    @FXML
    void sumando(ActionEvent event) {

        try{ //! Es como un 'if' pero más preciso.
            int op1=Integer.parseInt(this.txtOp1.getText()); // Conversión
            int op2=Integer.parseInt(this.txtOp2.getText()); // Conversión

            Suma suma=new Suma(op1, op2);

            int resultado=suma.suma(); //! Se crea una variable 'Resutado'...
            //! para que en el 'this.txtresultado' no se ande confundiendo...
            //! en la llamada de la clase 'Suma'.

            this.txtResultado.setText((resultado+""));
            System.out.println("El resultado es: "+resultado); // Print para la consola

        }catch (NumberFormatException e){
            Alert alerta=new Alert(AlertType.ERROR);

            System.out.println("=".repeat(35)); // Print para la consola
            System.out.println("ERROR"+"\nFORMATO INCORRECTO"+"\nINGRESE EL FORMATO CORRESPONDIENTE"+"\nESPERANDO CONFIRMACIÓN..."); // Print para la consola

            alerta.setTitle("ERROR"); //? Título de la alerta.

            // System.out.println("ERROR"); // Print para la consola
            
            
            alerta.setHeaderText("FORMATO INCORRECTO"); //? Es la cabecera, estará...
            //? arriba para mostrar el mensaje que deseas poner...
            //? se recomienda colocar y activar esto sólo cuando...
            //? sea necesario, ya que se ve algo feo.

            // System.out.println("FORMATO INCORRECTO"); // Print para la consola

            alerta.setContentText("INGRESE EL FORMATO CORRESPONDIENTE"); //? Contexto de la alerta.

            // System.out.println("INGRESE EL FORMATO CORRESPONDIENTE"); // Print para la consola

            System.out.println("=".repeat(35)); // Print para la consola

            alerta.showAndWait(); //? Al mostrar el mensaje esperará a...
            //? que confirmes para después desaparecer, no se cerrará...
            //? el programa.

            // System.out.println("ESPERANDO CONFIRMACIÓN..."); // Print para la consola
        }
    }

}
