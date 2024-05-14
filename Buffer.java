package org.example;

import java.util.ArrayList;

public class Buffer {
    private final ArrayList<Product> products;
    private final int maxBufferStorage;
    private int currentStorage;

    Buffer(int maxBufferStorage) {
        products = new ArrayList<Product>();
        this.maxBufferStorage = maxBufferStorage;
        currentStorage = 0;
    }

    public synchronized void put(Product p) throws InterruptedException {
        if (currentStorage < maxBufferStorage) {
            currentStorage += 1;
            products.add(p);
            System.out.println("Buffer: put ... " + p);
        } else {
            System.out.println("Buffer: buffer full ...");
            System.out.println(products);
        }
    }

    public synchronized Boolean get(Product p) throws InterruptedException {
        boolean removed = products.remove(p);
        if (removed) {
            currentStorage -= 1;
            System.out.println("Buffer: get ... " + p);
        } else {
            System.out.println("Buffer: get ... no product found.");
        }
        return removed;
    }
}
