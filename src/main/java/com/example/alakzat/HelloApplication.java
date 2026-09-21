package com.example.alakzat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;

        if(!ControllerTest.isRunningTest) scene = new Scene(fxmlLoader.load());
        if(!ControllerTest.isRunningTest) stage.setTitle("Diákok");
        if(!ControllerTest.isRunningTest) stage.setScene(scene);
        if(!ControllerTest.isRunningTest) stage.show();
    }

    public static void main(String[] args) {

        if (!ControllerTest.isRunningTest) launch();
    }

}
