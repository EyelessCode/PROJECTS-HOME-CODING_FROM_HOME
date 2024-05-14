package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SumaAgain implements Initializable{

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Image ivImage=new Image("C:\\Users\\Cristhian Guedes\\Documents\\Program_codes_Projects\\VSCode_Projects\\Java_Projects\\Home_Codes\\AGAIN-02-FX-SumaNumeros\\src\\imagenes\\unknown_man.jpg");
    }

    @FXML
    void accionConsejo1(MouseEvent event) {

    }

    @FXML
    void accionConsejo2(MouseEvent event) {

    }

    @FXML
    void accionConsejo3(MouseEvent event) {

    }

    @FXML
    void accionConsejo4(MouseEvent event) {

    }

    @FXML
    void proceso(ActionEvent event) {

    }


}
