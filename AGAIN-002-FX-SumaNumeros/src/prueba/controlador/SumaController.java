package prueba.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import prueba.modelo.Numero;

public class SumaController {

    @FXML
    private Button btnSumar;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private TextField txtResultado;

    @FXML
    void realizacionSuma(ActionEvent event) {
        try{
            long num1=Integer.parseInt(this.txtNum1.getText());
            long num2=Integer.parseInt(this.txtNum2.getText());

            Numero n=new Numero(num1, num2);

            long resultado=n.sumacion();

            this.txtResultado.setText(resultado+"");

            // Consola
            System.out.println("=".repeat(100));
            System.out.println("Consola:"+"\nResultado: "+resultado);
            System.out.println("=".repeat(100));

        }catch (NumberFormatException nfe){
            Alert alerta=new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR GENERADO");
            alerta.setHeaderText("FORMATO INCORRECTO");
            alerta.setContentText("EL FORMATO QUE ESTÁ APLICANDO ES INVÁLIDO. INTÉNTELO DE NUEVO.");

            // Consola
            System.out.println("=".repeat(100));
            System.out.println("Consola:\n>>> ERROR GENERADO\n>>> FORMATO INCORRECTO\nEL FORMATO QUE ESTÁ APLICANDO ES INVÁLIDO. INTÉNTELO DE NUEVO.");
            System.out.println("=".repeat(100));

            alerta.showAndWait();
        }
    }
}
