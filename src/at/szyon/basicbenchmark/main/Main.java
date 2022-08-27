package at.szyon.basicbenchmark.main;

import at.szyon.basicbenchmark.BasicBenchmark;
import at.szyon.basicbenchmark.benchmark.Benchmark;
import at.szyon.basicbenchmark.benchmark.cpu.CPU;
import at.szyon.basicbenchmark.benchmark.ram.RAM;
import at.szyon.basicbenchmark.console.Console;
import at.szyon.basicbenchmark.console.ConsoleChannel;

public class Main {

    public static void main(String[] args) {
        try {
            Benchmark.setInstance(new Benchmark());

            Console.printLine(ConsoleChannel.OUTPUT, "-<>-<BasicBenchmark v." + BasicBenchmark.INFO.getVersion().toString() + " by "+BasicBenchmark.INFO.getAuthorsAsString(",")+">-<>-");
            Console.printLine(ConsoleChannel.OUTPUT, "Modes: [CPU = 1], [RAM = 2]");
            int mode;
            int executionTime;
            try {
                mode = Math.abs(Console.getInputInteger("Which mode do you want to run?: "));
                executionTime = Math.abs(Console.getInputInteger("How long to run the benchmark? (seconds): ")) * 1000;
            } catch (Exception e) {
                throw new Exception("The input has to be an integer!");
            }

            Console.printEmpty();
            switch (mode) {
                case 1 -> {
                    Benchmark.getInstance().runCpu(System.currentTimeMillis(), executionTime);
                    break;
                }
                case 2 -> {
                    Benchmark.getInstance().runRam(System.currentTimeMillis(), executionTime);
                    break;
                }
                default -> {
                    Console.printLine(ConsoleChannel.ERROR, "The input has to be 1 or 2!");
                    System.exit(0);
                }
            }

            int benchmarkResult = Benchmark.getInstance().getResult();
            long storedBytes = 0;
            if(mode == 2) {
                Console.printLine(ConsoleChannel.OUTPUT, "counting Bytes...");
                storedBytes = RAM.storedBytes();
            }

            Console.printEmpty();
            Console.printLine(ConsoleChannel.OUTPUT, "Result: " + benchmarkResult + " points");
            if(mode == 2) {
                Console.printLine(ConsoleChannel.OUTPUT, (storedBytes / 1024f / 1024f) + "MB where stored in the RAM");
            }

            CPU.clearup();
            RAM.clearup();
            System.gc();

            Console.printEmpty();
            Console.anyKey("Press any key to exit");
            System.exit(0);
        } catch (Exception e) {
            Console.printEmpty();
            Console.printLine(ConsoleChannel.ERROR, "An unexpected error occurred!");
            Console.printLine(ConsoleChannel.ERROR, e.getMessage());
            Console.printLine(ConsoleChannel.ERROR, "Exiting...");
            Console.printEmpty();
            System.exit(0);
        }
    }

}
