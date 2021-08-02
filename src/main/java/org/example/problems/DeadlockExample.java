package org.example.problems;

public class DeadlockExample {

        volatile boolean isNotified = false;

        public synchronized void writer() {
            try
            {
                isNotified = false;
                while (!isNotified)
                    wait();
                notifyAll();
                System.out.println("Method 1");
            } catch (InterruptedException e) {/*NOP*/}
        }

        public synchronized void reader() {
            try {
                isNotified = true;
                while (isNotified)
                    wait();
                notifyAll();
                System.out.println("Method 2");
            } catch (InterruptedException e) {/*NOP*/}

        }

        public static void main(String[] args)
        {
            DeadlockExample example = new DeadlockExample();

            Thread thread1 = new Thread()
            {

                public void run()
                {
                    example.writer();
                }
            };
            Thread thread2 = new Thread()
            {

                public void run()
                {
                    example.reader();
                }
            };

            thread1.start();
            thread2.start();
        }

}
