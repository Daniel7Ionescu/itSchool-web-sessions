package com.dan.restone.practice.exceptions_practice.variants;

public class StringExceptionHandling {

    public static void main(String[] args) {

        String input = "Hello";

        int validIndex = 0;
        int invalidIndex = input.length();

        printCharAt(input, invalidIndex);

    }

    private static void printCharAt(String str, int index){
        try {
            System.out.println("Char at index: " + index + ": " + str.charAt(index));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBounds was thrown: " + e.getMessage());
        }
    }
}
