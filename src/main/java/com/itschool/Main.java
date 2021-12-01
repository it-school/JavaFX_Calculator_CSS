package com.itschool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_view.fxml")));
      primaryStage.setTitle("CalculatorFX");
      primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("images/calculator.png")).toExternalForm()));
//    primaryStage.setScene(new Scene(root, 800, 600));
      primaryStage.setScene(new Scene(root));
      primaryStage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/styles.css")).toExternalForm());  // CSS из внешнего файла

      primaryStage.setResizable(false);  // запрещаем менять размеры окна
//    primaryStage.initStyle(StageStyle.UNDECORATED);  // скрываем элементы управления окном (свернуть, развернуть, закрыть)

      // CSS локально
      root.styleProperty().setValue("-fx-background-color: lightblue; -fx-background-radius: 20px; -fx-border-color: darkblue; -fx-border-radius: 20px; -fx-border-width: 5px;"); //
      primaryStage.show();
   }
}