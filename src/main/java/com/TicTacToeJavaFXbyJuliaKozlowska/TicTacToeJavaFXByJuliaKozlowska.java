package com.TicTacToeJavaFXbyJuliaKozlowska;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.stage.WindowEvent;

import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;

public class TicTacToeJavaFXByJuliaKozlowska extends Application {

    public static Stage mainWindow;
    @Override
    public void start(Stage stage) throws IOException {
        mainWindow = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeJavaFXByJuliaKozlowska.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), AppConstants.WIN_MIN_WIDTH, AppConstants.WIN_MIN_HEIGHT);
        mainWindow.setTitle("Tic-tac-toe JavaFX by Julia Kozlowska");

        GameSettings gameSettings = new GameSettings();
        gameSettings.setGameSkin(GameSettings.Skin.DEFAULT);


        ChangeListener<Number> heightListener = (observable, oldValue, newValue) -> {
            if (mainWindow.isShowing() && newValue.doubleValue() >= AppConstants.WIN_MIN_HEIGHT) {
                AppConstants.systemTitleBarErrorValue = mainWindow.getHeight() - AppConstants.WIN_MIN_HEIGHT;
                mainWindow.setMinWidth(AppConstants.WIN_MIN_WIDTH);
                mainWindow.setMinHeight(AppConstants.WIN_MIN_HEIGHT + AppConstants.systemTitleBarErrorValue);
                mainWindow.setMaxWidth(AppConstants.WIN_MAX_WIDTH);
                mainWindow.setMaxHeight(AppConstants.WIN_MAX_HEIGHT + AppConstants.systemTitleBarErrorValue);
            }
        };

        Platform.runLater(() -> {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    mainWindow.heightProperty().removeListener(heightListener);
                }
            };
            timer.schedule(task, 500);
        });

        mainWindow.heightProperty().addListener(heightListener);

        mainWindow.setScene(scene);
        mainWindow.show();

    }

    @Override
    public void stop() {
        System.out.println("Application is stopping...");
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}