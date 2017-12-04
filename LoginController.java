package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;


public class LoginController {
    String acc = "admin";
    //The reference of userName will be injected by the FXML Loader
    @FXML
    private TextField user;

    @FXML
    private Label warningMsg;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    public void handleButtonActionSignIn(ActionEvent event)throws Exception{
    if (user.getText().equals(acc)){
        Parent root = FXMLLoader.load(getClass().getResource( "../gui/profile.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }else{
        warningMsg.setText("Invalid User name");
    }
    }

    public void handleButtonActionRegister(ActionEvent event)throws Exception{
    Parent page = FXMLLoader.load(getClass().getResource("../gui/register.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {

    }

  
}

