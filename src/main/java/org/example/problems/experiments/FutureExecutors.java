package org.example.problems.experiments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExecutors {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Integer> doSomething(Integer value) {
        return executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return value * value;
        });
    }

}
