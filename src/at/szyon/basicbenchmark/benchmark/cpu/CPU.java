package at.szyon.basicbenchmark.benchmark.cpu;

import at.szyon.basicbenchmark.console.Console;
import at.szyon.basicbenchmark.console.ConsoleChannel;

import java.lang.management.ManagementFactory;

public class CPU {
    private static CPUThread[] threads;

    public static void start() {
        CPU.createThreads();

        Console.printLine(ConsoleChannel.CPU, "starting...");

        for(int i = 0; i < CPU.threads.length; i++) {
            CPU.threads[i].start();
        }
        Console.printLine(ConsoleChannel.CPU, "running...");

        boolean check = true;
        while(check) {
            for(int i = 0; i < CPU.threads.length; i++) {
                check = threads[i].isAlive() && check;
            }
            System.gc();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void createThreads() {
        Console.printLine(ConsoleChannel.CPU, "creating Threads...");

        int coreCount =  ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();

        CPU.threads = new CPUThread[coreCount * 2];
        for(int i = 0; i < threads.length; i++) {
            CPU.threads[i] = new CPUThread();
        }

        Console.printLine(ConsoleChannel.CPU, "created " + (threads.length) + " Threads");
    }

    public static int coreCount() {
        if(threads == null) {
            return -1;
        }

        return threads.length;
    }

    public static void clearup() {
        CPU.threads = null;
    }


}
