package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelos.Numeros;

public class SumaAgain{

    @FXML
    private Button btnFoto;

    @FXML
    private Button btnResultado;

    @FXML
    private ImageView ivFoto;

    @FXML
    private TextArea txtConsejo;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private TextField txtresultado;

    @FXML
    void accionConsejo1(MouseEvent event) {
        // if(this.txtConsejo.isPickOnBounds()){
        //     this.txtConsejo.setText("AAAA");
        // }if(this.txtConsejo.)
        if(this.txtConsejo.getCursor() != null){
            this.txtConsejo.setText("Aquí debes de ingresar el primer número que vas a calcular");

            System.out.println("=".repeat(45));
            System.out.println("CONSOLA\nAquí debes de ingresar el primer número que vas a calcular");
            System.out.println("=".repeat(45));
        }
        // else{
        //     this.txtConsejo.setText("XD");
        // }
        
        // while(!this.txtConsejo.isPickOnBounds()){
        //     this.txtConsejo.setText(null);
        // }

        // this.txtConsejo.setText("Aquí debes de ingresar el primer número que vas a calcular");
    }

    @FXML
    void accionConsejo2(MouseEvent event) {
        if(this.txtConsejo.getCursor() != null){
            this.txtConsejo.setText("Aquí debes de ingresar el segundo número que vas a calcular");

            System.out.println("=".repeat(45));
            System.out.println("CONSOLA\nAquí debes de ingresar el segundo número que vas a calcular");
            System.out.println("=".repeat(45));
        }
    }

    @FXML
    void accionConsejo3(MouseEvent event) {
        if(this.txtConsejo.getCursor() != null){
            this.txtConsejo.setText("Tienes que generar una respuesta para que la respuesta sea visualizada por acá.");
            
            System.out.println("=".repeat(100));
            System.out.println("CONSOLA\nTienes que generar una respuesta para que la respuesta sea visualizada por acá.");
            System.out.println("=".repeat(100));
        }
    }

    @FXML
    void accionConsejo4(MouseEvent event) {
        if(this.txtConsejo.getCursor() != null){
            this.txtConsejo.setText("Esta es tu foto de perfil, puedes cambiarla cuando gustes dándole el botón de 'Cambiar perfil'");
        
            System.out.println("=".repeat(100));
            System.out.println("CONSOLA\nEsta es tu foto de perfil, puedes cambiarla cuando gustes dándole el botón de 'Cambiar perfil'");
            System.out.println("=".repeat(100));
        }
    }

    @FXML
    void cambioFoto(ActionEvent event) {
        //! IMPORTANTE SABER
        FileChooser cambioFoto=new FileChooser();
        cambioFoto.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imágenes","*.png","*.jpg","*.jpeg"));

        Stage escenerio=(Stage) btnFoto.getScene().getWindow();
        File seleccion=cambioFoto.showOpenDialog(escenerio);

        if(seleccion!=null){
            Image select=new Image(seleccion.toURI().toString());
            ivFoto.setImage(select);

            System.out.println("=".repeat(100));
            System.out.println("Seleccionando imagen...");
            System.out.println("=".repeat(100));
        }
    }

    @FXML
    void proceso(ActionEvent event) {
        try{
            long num1=Integer.parseInt(this.txtNum1.getText());
            long num2=Integer.parseInt(this.txtNum2.getText());

            Numeros n=new Numeros(num1, num2);

            long resultado=n.suma();

            this.txtresultado.setText(resultado+"");
            //
            System.out.println("=".repeat(100));
            System.out.println("CONSOLA:\nEl resultado es: "+resultado);

        }catch (NumberFormatException e){
            Alert alerta=new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR GENERADO");
            alerta.setHeaderText("FORMATO INCORRECTO");
            alerta.setContentText("NECESITA INGRESAR UN FORMATO NÚMERO TIPO 'ENTERO', LOS DEMÁS NO SON VÁLIDOS");

            System.out.println("=".repeat(100));
            System.out.println("CONSOLA:\nERROR GENERADO\nFORMATO INCORRECTO\nNECESITA INGRESAR UN FORMATO NÚMERO TIPO 'ENTERO', LOS DEMÁS NO SON VÁLIDOS"
            +"\nESPERANDO CONFIRMACIÓN...");
            alerta.showAndWait();
        }
    }


}
