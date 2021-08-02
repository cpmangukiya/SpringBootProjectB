package org.example.problems.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerUsingWaitNotify {
    final static Queue queue = new ArrayDeque();

    public static void main(String[] args) {
        Thread producer  = new Thread(new Producer(queue, 4));
        Thread consumer  = new Thread(new Consumer(queue, 4));

        producer.start();
        consumer.start();
    }

}

class Producer implements Runnable {
    private Queue queue;
    private int maxSize;
    public Producer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue) {
                while(queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                int value = new Random().nextInt(100);
                System.out.println("Produced value " + value);
                queue.add(value);
                queue.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue queue;
    private int maxSize;
    public Consumer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumed value " + queue.poll());
                queue.notify();
            }
        }
    }
}
