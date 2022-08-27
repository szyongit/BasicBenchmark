package at.szyon.basicbenchmark.console;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    private static Scanner inputScanner;

    public static void print(ConsoleChannel channel, String message) {
        System.out.print(channel.getOutputText() + "" + message);
    }

    public static void printLine(ConsoleChannel channel, String message) {
        System.out.println(channel.getOutputText() + "" + message);
    }

    public static void printEmpty() {
        System.out.println("");
    }

    public static void anyKey(String message) throws IOException {
        Console.print(ConsoleChannel.OUTPUT, message + "...");
        System.in.read();
    }

    public static String getInputLine(String message) {
        if(inputScanner == null) {
            inputScanner = new Scanner(System.in);
        }

        Console.print(ConsoleChannel.INPUT, message);
        String result = inputScanner.nextLine();
        return result;
    }

    public static int getInputInteger(String message) {
        if(inputScanner == null) {
            inputScanner = new Scanner(System.in);
        }

        Console.print(ConsoleChannel.INPUT, message);
        int result = inputScanner.nextInt();
        return result;
    }

    public static void anyInputKey(String message) {
        if(inputScanner == null) {
            inputScanner = new Scanner(System.in);
        }

        Console.print(ConsoleChannel.INPUT, message);
        inputScanner.next();
    }

}
