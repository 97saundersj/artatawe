package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Database;

/**
 * This is the class for viewing other users' information
*@Author Marco
 */
public class ViewUser {

    Database database;
    public void setDatabase(Database database) {
        this.database = database;
    }

    @FXML
    private Label functionTester;
    private Label firstName, lastName, adress, phoneNo, userName, postCode;

    @FXML
    private ImageView avatar;

    @FXML
    private Button closeBtn;

    @FXML
    private ListView artworkList, favArtworkList, favUserList, bidWonList, bidPlacedList;

    @FXML
    public void closeWindow()throws Exception{
        //This is the action for Home button, user can back to home page by this button
        Stage currentStage = (Stage) closeBtn.getScene().getWindow();
        currentStage.close();
    }


    @FXML
    public void artworkViewMouseClick(MouseEvent click)throws Exception {
        //this is the mouse click event for user to double the list item to get in to viewing page
        if(click.getClickCount() == 2) {
            System.out.println("clicked on " + artworkList.getSelectionModel().getSelectedItem());
            Parent root = FXMLLoader.load(getClass().getResource("../gui/viewArt.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void favUserViewMouseClick(MouseEvent click)throws Exception {
        //this is the mouse click event for user to double the list item to get in to viewing page
        if(click.getClickCount() == 2) {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/profile.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void initialize() throws Exception {
        /**
         *TODO this help for getting data from profile and show on the gui page
         userName.setText(profile.getUserName);
         firstName.setText(profile.getfFirstName*/
    }

}
