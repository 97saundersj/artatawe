package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Database;

/**
 *This is the class for viewing the own artwork, which can add two more images for uploaded artwork
 * @Author Marco
 */
public class ArtworkViewOwn {

    Database database;
    public void setDatabase(Database database) {
        this.database = database;
    }

    @FXML
    private ImageView artworkImageMain, artworkImageMini1, artworkImageMini2;

    @FXML
    private Button placeBidBtn, closeBtn, addFavUserBtn, addFavArtBtn;

    @FXML
    public void closeWindow()throws Exception{
        //This is the action for Close button, user can close current window by this action
        Stage currentStage = (Stage) closeBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void browseImage() throws Exception {
        //this is the action of uploading an artwork by browsing the file in local system
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        fileChooser.showOpenDialog(stage);
    }

    @FXML
    private void initialize(){

    }
}
