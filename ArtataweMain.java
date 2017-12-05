import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * LocalDateTime t = LocalDateTime.now();
 * **TODO fully**
 * temporarily, a class to provide a text based ui to database to test the operations of storing and loading data
 * that the database subsystem provides
 * cant be called main, pretty sure the main is just meant to have static method and nothing else
 */
public class ArtataweMain extends Application {
	public ArtataweMain() {
		
	}
	
	@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        primaryStage.setTitle("Artatawe");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }

}
