package com.itschool;

import com.itschool.classes.Calculator;
import com.itschool.classes.Operation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CalculatorController {
   @FXML
   private TextField display;
   private @FXML
   Label lblMemory;
   private boolean isOperationPressed = false;
   private boolean isCalculatePressed = false;
   private Calculator calculator;

   @FXML
   public void initialize() {
      this.calculator = new Calculator();
   }

   public void btnOperationClick(ActionEvent actionEvent) {
      try {
         calculator.setNumber1(Double.parseDouble(display.getText()));

         switch (((Button) actionEvent.getSource()).getText()) {
            case "+" -> calculator.setOperation(Operation.plus);
            case "-" -> calculator.setOperation(Operation.minus);
            case "*" -> calculator.setOperation(Operation.multiply);
            case "/" -> calculator.setOperation(Operation.divide);
            case "√" -> {
               calculator.setOperation(Operation.sqrt);
               calculator.calculate();
               display.setText(calculator.getResult());
            }
         }
         isOperationPressed = true;
      } catch (Exception ignored) {

      }
      isCalculatePressed = false;

   }

   public void numberBtnClick(ActionEvent actionEvent) {
      if (isOperationPressed) {
         display.setText("0");
         isOperationPressed = false;
      }

      getValueFromDisplay(actionEvent);
      isCalculatePressed = false;

   }

   private void getValueFromDisplay(ActionEvent actionEvent) {
      String displayText = display.getText();
      try {
         if (Double.parseDouble(displayText) == 0)
            display.setText(((Button) actionEvent.getSource()).getText());
         else
            display.setText(display.getText() + ((Button) actionEvent.getSource()).getText());
      } catch (Exception ignored) {

      }
   }

   public void btnClearClick() {
      display.setText("0");
      calculator.clearAll();
      isCalculatePressed = false;
   }

   public void btnMemoryPlusClick() {
      calculator.setMemory(calculator.getMemory() + Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryMinusClick() {
      calculator.setMemory(calculator.getMemory() - Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryStoreClick() {
      calculator.setMemory(Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryReadClick() {
      display.setText(calculator.getMemory() + "");
      displayMemoryState();
   }

   public void btnMemoryClearClick() {
      calculator.setMemory(0);
      displayMemoryState();
   }

   public void displayMemoryState() {
      lblMemory.setVisible(calculator.getMemory() != 0);
   }

   public void btnCalculateClick() {
      if (!isCalculatePressed)
         calculator.setNumber2(Double.parseDouble(display.getText()));

      calculator.calculate();
      display.setText(calculator.getResult());

      try {
         calculator.setNumber1(Double.parseDouble(calculator.getResult()));
      } catch (Exception ignored) {

      }

      isCalculatePressed = true;
   }

   public void changeSignClick() {
      display.setText(-Double.parseDouble(display.getText()) + "");
   }

   public void eraseLastChar() {
      String displayText = display.getText();
      display.setText(displayText.substring(0, displayText.length() - 1));
   }
}