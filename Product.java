package org.example;

import java.util.Random;

public enum Product {
    CARROT,
    POTATO,
    CUCUMBER,
    CABBAGE,
    ONION;

    private static final Random random = new Random();
    public static Product getRandomProduct() {
        return values()[random.nextInt(values().length)];
    }
}
