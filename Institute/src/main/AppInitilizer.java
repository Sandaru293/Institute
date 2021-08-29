package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stages.StageList;

import java.io.IOException;

public class AppInitilizer extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"))));
        primaryStage.show();
        StageList.loginFormStage = primaryStage;
    }
}
