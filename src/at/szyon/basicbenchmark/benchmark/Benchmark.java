package at.szyon.basicbenchmark.benchmark;

import at.szyon.basicbenchmark.benchmark.cpu.CPU;
import at.szyon.basicbenchmark.benchmark.ram.RAM;

public class Benchmark {

    private static Benchmark instance;
    private int executionTime;
    private int resultPoints;
    private boolean isRunning;
    private long startPoint;

    public void runCpu(long startPoint, int executionTime) {
        this.setStartPoint(startPoint);
        this.setExecutionTime(executionTime);

        this.setRunning(true);
        CPU.start();
        this.setRunning(false);
    }

    public void runRam(long startPoint, int executionTime) {
        this.setStartPoint(startPoint);
        this.setExecutionTime(executionTime);

        this.setRunning(true);
        RAM.start();
        this.setRunning(false);
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getExecutionTime() {
        return this.executionTime;
    }

    public synchronized int getResult() {
        return this.resultPoints;
    }

    public synchronized void addResultPoints(final int points) {
        this.resultPoints += points;
    }

    public static void setInstance(Benchmark benchmark) {
        Benchmark.instance = benchmark;
    }

    public static Benchmark getInstance() {
        return Benchmark.instance;
    }

    public long getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(long startPoint) {
        this.startPoint = startPoint;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public boolean isRunning() {
        return this.isRunning && ((this.startPoint + this.executionTime) > System.currentTimeMillis());
    }
}
