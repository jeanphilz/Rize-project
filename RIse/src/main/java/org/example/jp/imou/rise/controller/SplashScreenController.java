package org.example.jp.imou.rise.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
    @FXML
    private AnchorPane AnchorSplash;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        simulateLoading();
    }

    private void simulateLoading() {
        Task<Void> loadingTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Simulate loading tasks
                Thread.sleep(3000); // Simulate a 3-second loading time

                return null;
            }
        };

        loadingTask.setOnSucceeded(event -> {
            // Loading is complete, proceed to show the main window
            showMainWindow();
        });

        // Start the loading task in a separate thread
        new Thread(loadingTask).start();
    }

    private void showMainWindow() {
        Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/org/example/jp/imou/rise/login-view.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Rise | Login");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

                // Close the splash screen
                closeSplashScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }



    private void closeSplashScreen() {
        Stage splashStage = (Stage) AnchorSplash.getScene().getWindow();
        splashStage.close();
    }

}
