package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import sample.Database;

/**
 * The controller of searching screen gui
 * @Author Marco
 * TODO need to be able to get data from database
 */
public class SearchGui {
    String searchTest =  "test";

    @FXML
    private Label warningMsg;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchBtn, backToProfileBtn, logoutBtn;

    @FXML
    private CheckBox sculptureFilter, paintingFilter, favouriteFilter;

    @FXML
    public void filterSearch()throws Exception {
        //This method contains two filter, one is sculpture and one is painting, user can search the artwork type they want by clicking the checkbox of those.
        Stage currentStage = (Stage) searchBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/results.fxml"));;
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        if (searchBar.getText().equals(searchTest)) {
            warningMsg.setText("");
            if (sculptureFilter.isSelected() && !paintingFilter.isSelected() && !favouriteFilter.isSelected()) {
                //filter of searching sculpture only
                System.out.println("Test for sculpture");
                currentStage.close();
                stage.setScene(scene);
                stage.show();
            } else if (paintingFilter.isSelected() && !sculptureFilter.isSelected() && !favouriteFilter.isSelected()) {
                //filter of searching painting only
                System.out.println("Test for painting");
                currentStage.close();
                stage.setScene(scene);
                stage.show();
            } else if (favouriteFilter.isSelected() && !sculptureFilter.isSelected() && !paintingFilter.isSelected()){
                System.out.println("Test for favourite");
                currentStage.close();
                stage.setScene(scene);
                stage.show();
            }else{
                //filter of  searching both
                System.out.println("Test for all");
                currentStage.close();
                stage.setScene(scene);
                stage.show();
            }
        }else{
            warningMsg.setText("Invalid Keywords" );
        }
    }

    @FXML
    public void logout(ActionEvent event)throws Exception{
        //This is the action for logout button, user can logout by this button and go back to the login page
        Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
        currentStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toProfile(ActionEvent event)throws Exception{
        //This is the button action for switching back to the profile page
        Stage currentStage = (Stage) backToProfileBtn.getScene().getWindow();
        currentStage.close();
        Parent page = FXMLLoader.load(getClass().getResource("../gui/home.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
    }


    public TextField getSearchBar(){
        return searchBar;
    }

    private void initialize() {

    }

}
