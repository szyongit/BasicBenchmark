package at.szyon.basicbenchmark.benchmark.cpu;

import at.szyon.basicbenchmark.benchmark.Benchmark;

import java.util.Base64;
import java.util.Random;

public class CPUThread extends Thread {

    public CPUThread() {
        super(() -> {
            while(Benchmark.getInstance().isRunning()) {
                Base64.getEncoder().encode(randomString(5000).getBytes());
                Benchmark.getInstance().addResultPoints(1);
            }
        });
    }

    private static int randomInt(int minimum, int range) {
        return (new Random().nextInt() % range) + minimum;
    }

    private static String randomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomChar = randomInt(65, 61);
            stringBuilder.append((char)randomChar);
        }
        return stringBuilder.toString();
    }
}
