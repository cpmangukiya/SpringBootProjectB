package org.example.problems.experiments;

import java.util.Spliterator;

public class SpliteratorTask {

    Spliterator<Integer> spliterator;

    public SpliteratorTask(Spliterator<Integer> spliterator) {
        this.spliterator = spliterator;
    }

    public String call() {
        int current = 0;
        while (spliterator.tryAdvance(a -> System.out.println(a.toString()))) {
            current++;
        }
        System.out.println(Thread.currentThread().getName() + ":" + current);
        return Thread.currentThread().getName() + ":" + current;
    }

}
