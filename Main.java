package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREADS_NUMBER = 5;
    private static final int BUFFER_STORAGE_SIZE = 10;

    public static void main(String[] args) {
        System.out.println("Press Enter, to stop the program.");

        final ExecutorService prodExecutor = Executors.newFixedThreadPool(THREADS_NUMBER);
        final ExecutorService consExecutor = Executors.newFixedThreadPool(THREADS_NUMBER);

        Buffer b = new Buffer(BUFFER_STORAGE_SIZE);

        ArrayList<Runnable> consumers = new ArrayList<>();
        ArrayList<Runnable> producers = new ArrayList<>();

        for(int i = 0; i < THREADS_NUMBER; i++) {
            Runnable c = new Consumer(b);
            consumers.add(c);
            consExecutor.submit(c);

            Runnable p = new Producer(b);
            producers.add(p);
            prodExecutor.submit(p);
        }


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        for(int i = 0; i < THREADS_NUMBER; i++) {
            Runnable c = consumers.get(i);
            ((Consumer) c).stop();

            Runnable p = producers.get(i);
            ((Producer) p).stop();
        }

        prodExecutor.shutdown();
        consExecutor.shutdown();
    }
}
