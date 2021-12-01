module com.itschool.javafx_calculator {
   requires javafx.controls;
   requires javafx.fxml;

   opens com.itschool to javafx.fxml;
   exports com.itschool;
}