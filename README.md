# Producer-Consumer Problem Solution in Java

This Java program demonstrates the solution to the Producer-Consumer problem using multiple threads. The program implements a model where there are multiple producers and consumers operating on a shared buffer.

## Overview

The Producer-Consumer problem is a classic synchronization problem where there are two types of threads - producers and consumers - that share a common, fixed-size buffer. Producers produce items and place them into the buffer, while consumers retrieve items from the buffer and consume them.

In this program:
- Multiple producer threads produce random products and attempt to add them to the buffer.
- Multiple consumer threads attempt to retrieve random products from the buffer and consume them.
- Both producers and consumers execute their tasks cyclically, with random delays to simulate real-world scenarios.

## Implementation Details

### Classes
1. `Main`: The main class that initializes the producer and consumer threads, manages their execution, and terminates the program upon pressing Enter.
2. `Buffer`: Represents the shared buffer where products are stored. Implements methods for adding and removing products from the buffer, ensuring thread safety.
3. `Producer`: Represents a producer thread that produces and adds products to the buffer.
4. `Consumer`: Represents a consumer thread that consumes products from the buffer.

### Flow
1. The `Main` class initializes a fixed thread pool for producers and consumers, along with the shared buffer.
2. Multiple producer and consumer threads are created and submitted to their respective thread pools for execution.
3. The program waits for the user to press Enter, upon which it stops all producer and consumer threads and shuts down the thread pools.

### Key Points
- The producer and consumer threads are synchronized to ensure thread safety when accessing the shared buffer.
- Random delays are introduced in the execution of producer and consumer tasks to simulate real-world scenarios and prevent busy loops.



