package com.itschool.classes;

public class Calculator {
   Operation operation;
   private double number1, number2, memory;
   private String result;

   public Operation getOperation() {
      return operation;
   }

   public void setOperation(Operation operation) {
      this.operation = operation;
   }

   public double getNumber1() {
      return number1;
   }

   public void setNumber1(double number1) {
      this.number1 = number1;
   }

   public double getNumber2() {
      return number2;
   }

   public void setNumber2(double number2) {
      this.number2 = number2;
   }

   public String getResult() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }

   public void calculate() {
      switch (operation) {
         case plus -> result = (number1 + number2) + "";
         case minus -> result = (number1 - number2) + "";
         case multiply -> result = (number1 * number2) + "";
         case divide -> result = number2 != 0 ? number1 / number2 + "" : "Division by zero";
         case sqrt -> result = number1 >= 0 ? Math.sqrt(number1) + "" : "Error calc sqrt of negative";
         default -> result = "Operation not defined";
      }

      try {
         double resDouble = Double.parseDouble(result);
         int resInt = (int) resDouble;
         if (Math.abs(resDouble - resInt) < 1E-14) result = resInt + "";
      } catch (Exception ignored) {
      }
   }

   public void clearAll() {
      this.setNumber1(0);
      this.setNumber2(0);
      this.setResult("");
   }

   public double getMemory() {
      return memory;
   }

   public void setMemory(double memory) {
      this.memory = memory;
   }
}