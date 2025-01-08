module com.TicTacToeJavaFXbyJuliaKozlowska {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.TicTacToeJavaFXbyJuliaKozlowska to javafx.fxml;
    exports com.TicTacToeJavaFXbyJuliaKozlowska;
}