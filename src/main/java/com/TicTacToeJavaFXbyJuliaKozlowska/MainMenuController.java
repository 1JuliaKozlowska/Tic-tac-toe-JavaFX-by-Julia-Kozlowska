package com.TicTacToeJavaFXbyJuliaKozlowska;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainMenuController {

    GameSettings gameSettings = new GameSettings();



    @FXML
    public void initialize() {
        gameSettings.setGameSkin(GameSettings.Skin.DEFAULT);
        updateGameSkin();
    }

    @FXML
    private ImageView oImage;
    @FXML
    private ImageView xImage;
    @FXML
    private Label skinSelectorLabel;

    public void updateGameSkin(){
        oImage.setImage(gameSettings.getOSkinImage(gameSettings.getGameSkin()));
        xImage.setImage(gameSettings.getXSkinImage(gameSettings.getGameSkin()));

        switch(gameSettings.getGameSkin()) {
            case DEFAULT:
            {
                skinSelectorLabel.setText("Current skin: Default");
                break;
            }
            case ALTERNATIVE:
            {
                skinSelectorLabel.setText("Current skin: Alternative");
                break;
            }
            case YUKKURI:
            {
                skinSelectorLabel.setText("Current skin: Yukkuri");
                break;
            }
            default:
            {
                skinSelectorLabel.setText("Current skin: Default");
                break;
            }
        }
    }


    @FXML
    protected void onSkinChangeLeftButtonClick(){
        gameSettings.previousSkin();
        updateGameSkin();
    }

    @FXML
    protected void onSkinChangeRightButtonClick(){
        gameSettings.nextSkin();
        updateGameSkin();
    }

    @FXML
    protected void onPlayAgainstAnotherPlayerButtonClick()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeJavaFXByJuliaKozlowska.class.getResource("game-window.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), AppConstants.WIN_MIN_WIDTH, AppConstants.WIN_MIN_HEIGHT);
            Stage stage = new Stage();
            GameWindowController controller = fxmlLoader.getController();
            controller.setGameSettings(gameSettings);
            controller.setGameMode(Game.GameMode.VSPLAYER);
            stage.setScene(scene);
            stage.show();
            TicTacToeJavaFXByJuliaKozlowska.mainWindow.hide();

            stage.setMinWidth(AppConstants.WIN_MIN_WIDTH);
            stage.setMinHeight(AppConstants.WIN_MIN_HEIGHT + AppConstants.systemTitleBarErrorValue);
            stage.setMaxWidth(AppConstants.WIN_MAX_WIDTH);
            stage.setMaxHeight(AppConstants.WIN_MAX_HEIGHT + AppConstants.systemTitleBarErrorValue);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    TicTacToeJavaFXByJuliaKozlowska.mainWindow.show();
                }
            });



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onPlayAgainstPCButtonClick()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeJavaFXByJuliaKozlowska.class.getResource("game-window.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load(), AppConstants.WIN_MIN_WIDTH, AppConstants.WIN_MIN_HEIGHT);
            Stage stage = new Stage();
            GameWindowController controller = fxmlLoader.getController();
            controller.setGameSettings(gameSettings);
            controller.setGameMode(Game.GameMode.VCCOMPUTER);
            stage.setScene(scene);
            stage.show();
            TicTacToeJavaFXByJuliaKozlowska.mainWindow.hide();

            stage.setMinWidth(AppConstants.WIN_MIN_WIDTH);
            stage.setMinHeight(AppConstants.WIN_MIN_HEIGHT + AppConstants.systemTitleBarErrorValue);
            stage.setMaxWidth(AppConstants.WIN_MAX_WIDTH);
            stage.setMaxHeight(AppConstants.WIN_MAX_HEIGHT + AppConstants.systemTitleBarErrorValue);

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    TicTacToeJavaFXByJuliaKozlowska.mainWindow.show();
                }
            });



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}