package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Home extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home");
        GridPane gridPane = createHome();
        addUIControls(gridPane);
        Scene scene1 = new Scene(gridPane, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private GridPane createHome() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        javafx.scene.control.Label headerLabel = new javafx.scene.control.Label("Welcome to Artatawe's Home Page");
        headerLabel.setFont(Font.font("Comic Sans", FontWeight.BOLD, 28));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.RIGHT);
        headerLabel.setAlignment(Pos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        javafx.scene.control.Button addArtwork = new javafx.scene.control.Button("Add Artwork");
        gridPane.add(addArtwork, 0,3,2,1);
        GridPane.setHalignment(addArtwork, HPos.RIGHT);
        GridPane.setMargin(addArtwork, new Insets(20, 0,20,0));


        javafx.scene.control.Button viewProfile = new javafx.scene.control.Button("View your profile");
        gridPane.add(viewProfile, 0,3,2,1);
        GridPane.setHalignment(viewProfile, HPos.LEFT);
        GridPane.setMargin(viewProfile, new Insets(20, 0,20,0));


        javafx.scene.control.Button searchForArtworks = new javafx.scene.control.Button("Search for artwork");
        gridPane.add(searchForArtworks, 0,3,2,1);
        GridPane.setHalignment(searchForArtworks, HPos.CENTER);
        GridPane.setMargin(searchForArtworks, new Insets(20, 0,20,0));


        javafx.scene.control.Button submitButton = new Button("Logout");
        submitButton.setPrefHeight(60);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(80);
        gridPane.add(submitButton, 0, 10, 4, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(0, 0, 20 ,0));

    };

    public static void main(String[] args) {
        launch(args);
    }
}
