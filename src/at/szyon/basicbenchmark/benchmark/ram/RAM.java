package at.szyon.basicbenchmark.benchmark.ram;

import at.szyon.basicbenchmark.benchmark.Benchmark;
import at.szyon.basicbenchmark.console.Console;
import at.szyon.basicbenchmark.console.ConsoleChannel;

import java.util.ArrayList;

public class RAM {

    private static ArrayList<byte[]> arrayList;
    private static int arraySize = 1024;

    public static void start() {
        Console.printLine(ConsoleChannel.RAM, "running...");

        RAM.arrayList = new ArrayList<>();
        while(Benchmark.getInstance().isRunning()) {
            long start = System.currentTimeMillis();
            for(int i = 0; i < arraySize; i++) {
                byte[] byteArray = new byte[arraySize];
                for(int j = 0; j < byteArray.length; j++) {
                    byteArray[j] = 1;
                }
                arrayList.add(byteArray);
            }

            Benchmark.getInstance().addResultPoints((int) ((System.currentTimeMillis() - start)));
        }
    }

    public static void clearup() {
        arrayList = null;
    }

    public static long storedBytes() {
        long result = 0;

        if(arrayList == null) {
            return -1;
        }

        for(byte[] byteArray : arrayList) {
            for(int i = 0; i < byteArray.length; i++) {
                result += byteArray[i];
            }
        }

        return result;
    }
}
