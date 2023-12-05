package com.dan.restone.practice.exceptions_practice.variants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicExceptionHandling {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the first number:");
            double num1 = scanner.nextInt();

            System.out.println("Enter the second number");
            double num2 = scanner.nextInt();

            double result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e){
            System.out.println("Cannot divide by 0");
        } catch (InputMismatchException e){
            System.out.println("Please enter a number");
        } catch (Exception e) {
            System.out.println("Help!" + e.getMessage());
        }
    }
}
