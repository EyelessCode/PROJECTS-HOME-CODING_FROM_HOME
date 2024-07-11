package prueba.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import prueba.modelo.Numero;

public class SumaFinalController {

    @FXML
    private Button btnFoto;

    @FXML
    private Button btnSuma;

    @FXML
    private ImageView ivImagen;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private TextField txtResultado;

    @FXML
    void calculo(ActionEvent event) {
        try{
            boolean puerta=true;

            long num1=Integer.parseInt(this.txtNum1.getText());
            long num2=Integer.parseInt(this.txtNum1.getText());

            Numero n=new Numero(num1, num2, num1, num2);

            long resultado=n.sumacion();

            this.txtResultado.setText(resultado+"");
        }catch (NumberFormatException nfe){
            Alert alerta=new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR GENERADO");
            alerta.setHeaderText("FORMATO INVÁLIDO");
            alerta.setContentText("EL FORMATO ES INVÁLIDO. VUELVA INTENTARLO.");
            alerta.showAndWait();
        }
    }

    @FXML
    void cambiarImagen(ActionEvent event) {

    }

}
