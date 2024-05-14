package org.example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private final Buffer producerBuffer;
    private volatile boolean running = true;

    public Producer(Buffer producerBuffer) {
        this.producerBuffer = producerBuffer;
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
                    producerBuffer.put(p);
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

