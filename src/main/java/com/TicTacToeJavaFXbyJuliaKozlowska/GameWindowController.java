package com.TicTacToeJavaFXbyJuliaKozlowska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;

public class GameWindowController {
    GameSettings gameSettings = new GameSettings();
    Image oSkinImage;
    Image xSkinImage;
    Image drawSkinImage;
    Game game = new Game();

    public void setGameSettings(GameSettings gs){
        this.gameSettings = gs;
        oSkinImage = gameSettings.getOSkinImage(gameSettings.getGameSkin());
        xSkinImage = gameSettings.getXSkinImage(gameSettings.getGameSkin());
        drawSkinImage = gameSettings.getDrawSkinImage(gameSettings.getGameSkin());
        game.setTurn(Game.Turn.O);
        updateTurnIndicator();

    }

    public void setGameMode(Game.GameMode gm){
        game.setGameMode(gm);
    }

    private void updateTurnIndicator(){
        switch (game.getTurn()){
            case O:
            {
                turnIndicatorImage.setImage(oSkinImage);
                break;
            }
            case X:
            {
                turnIndicatorImage.setImage(xSkinImage);
                break;
            }
            default:
            {
                break;
            }
        }
    }


    @FXML
    public void initialize() {

    }

    @FXML
    private ImageView turnIndicatorImage;
    @FXML
    private Label turnIndicatorLabel;

    @FXML
    private Label closeButton;

    @FXML
    private ImageView r0c0;
    @FXML
    private ImageView r0c1;
    @FXML
    private ImageView r0c2;
    @FXML
    private ImageView r1c0;
    @FXML
    private ImageView r1c1;
    @FXML
    private ImageView r1c2;
    @FXML
    private ImageView r2c0;
    @FXML
    private ImageView r2c1;
    @FXML
    private ImageView r2c2;


    public void r0c0Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(0,0)){
            r0c0.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(0,0);
        }
    }

    public void r0c1Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(0,1)){
            r0c1.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(0,1);
        }
    }

    public void r0c2Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(0,2)){
            r0c2.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(0,2);
        }
    }

    public void r1c0Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(1,0)){
            r1c0.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(1,0);
        }
    }

    public void r1c1Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(1,1)){
            r1c1.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(1,1);
        }
    }

    public void r1c2Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(1,2)){
            r1c2.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(1,2);
        }
    }

    public void r2c0Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(2,0)){
            r2c0.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(2,0);
        }
    }

    public void r2c1Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(2,1)){
            r2c1.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(2,1);
        }
    }

    public void r2c2Clicked(MouseEvent mouseEvent) {
        if (game.isPlaying && game.canPlace(2,2)){
            r2c2.setImage(game.getTurn() == Game.Turn.O ? oSkinImage : xSkinImage);
            turnAction(2,2);
        }
    }
    private void turnAction(int row, int col){
        game.nextTurn(row, col);

        if (game.isPlaying){
            updateTurnIndicator();
        }
        else if (game.draw)
        {
            turnIndicatorLabel.setText("Draw");
            turnIndicatorImage.setImage(drawSkinImage);
        }
        else
        {
            turnIndicatorLabel.setText("Won!");
        }



        if (game.getGameMode() == Game.GameMode.VCCOMPUTER && game.isPlaying){
            game.computerTurn();
            Game.GridField gameField[][] = game.getGameGrid();
            if (gameField[0][0] == Game.GridField.X){
                r0c0.setImage(xSkinImage);
            }
            if (gameField[0][1] == Game.GridField.X){
                r0c1.setImage(xSkinImage);
            }
            if (gameField[0][2] == Game.GridField.X){
                r0c2.setImage(xSkinImage);
            }
            if (gameField[1][0] == Game.GridField.X){
                r1c0.setImage(xSkinImage);
            }
            if (gameField[1][1] == Game.GridField.X){
                r1c1.setImage(xSkinImage);
            }
            if (gameField[1][2] == Game.GridField.X){
                r1c2.setImage(xSkinImage);
            }
            if (gameField[2][0] == Game.GridField.X){
                r2c0.setImage(xSkinImage);
            }
            if (gameField[2][1] == Game.GridField.X){
                r2c1.setImage(xSkinImage);
            }
            if (gameField[2][2] == Game.GridField.X){
                r2c2.setImage(xSkinImage);
            }

            if (game.isPlaying){
                updateTurnIndicator();
            }
            else if (game.draw)
            {
                turnIndicatorLabel.setText("Draw");
                turnIndicatorImage.setImage(drawSkinImage);
            }
            else
            {
                turnIndicatorLabel.setText("Won!");
            }
        }


    }

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        TicTacToeJavaFXByJuliaKozlowska.mainWindow.show();
        stage.close();

    }
}
