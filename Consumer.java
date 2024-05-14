package org.example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private final Buffer consumerBuffer;
    private static final Random random = new Random();
    private volatile boolean running = true;

    public Consumer(Buffer consumerBuffer) {
        this.consumerBuffer = consumerBuffer;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int n = ThreadLocalRandom.current().nextInt(0, 3);
            Product p = Product.getRandomProduct();

            for(int i = 0; i < n; i++) {
                try {
                    consumerBuffer.get(p);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void stop() {
        running = false;
    }
}

