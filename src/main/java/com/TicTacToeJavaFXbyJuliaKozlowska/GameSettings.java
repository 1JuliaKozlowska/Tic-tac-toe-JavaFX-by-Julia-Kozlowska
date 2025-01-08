package com.TicTacToeJavaFXbyJuliaKozlowska;

import javafx.scene.image.Image;

public class GameSettings {

    public enum Skin {
        DEFAULT,
        ALTERNATIVE,
        YUKKURI
    }

    private Skin gameSkin;
    private static final int skinsAmount = Skin.values().length;

    public void setGameSkin(Skin skin) {
        gameSkin = skin;
    }
    public Skin getGameSkin() {
        return gameSkin;
    }

    public void nextSkin(){
        if (gameSkin.ordinal() < skinsAmount - 1) {
            setGameSkin(Skin.values()[gameSkin.ordinal() + 1]);
        } else {
            setGameSkin(Skin.values()[0]);
        }
    }

    public void previousSkin(){
        if (gameSkin.ordinal() > 0) {
            setGameSkin(Skin.values()[gameSkin.ordinal() - 1]);
        } else {
            setGameSkin(Skin.values()[skinsAmount - 1]);
        }
    }

    public Image getOSkinImage(Skin skin){
        switch (skin){
            case DEFAULT:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/O.png").toExternalForm());
            }
            case ALTERNATIVE:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Oalt.png").toExternalForm());
            }
            case YUKKURI:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Oyukkuri.png").toExternalForm());
            }
            default:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/O.png").toExternalForm());
            }
        }
    }

    public Image getXSkinImage(Skin skin){
        switch (skin){
            case DEFAULT:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/X.png").toExternalForm());
            }
            case ALTERNATIVE:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Xalt.png").toExternalForm());
            }
            case YUKKURI:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Xyukkuri.png").toExternalForm());
            }
            default:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/X.png").toExternalForm());
            }
        }
    }

    public Image getDrawSkinImage(Skin skin){
        switch (skin){
            case DEFAULT:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Draw.png").toExternalForm());
            }
            case ALTERNATIVE:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Drawalt.png").toExternalForm());
            }
            case YUKKURI:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/DrawYukkuri.png").toExternalForm());
            }
            default:
            {
                return new Image(getClass().getResource("/com/TicTacToeJavaFXbyJuliaKozlowska/assets/Draw.png").toExternalForm());
            }
        }
    }
}
