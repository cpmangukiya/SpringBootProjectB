package org.example.problems.experiments;

public class Clock {
    protected long time = 0;    // time in milliseconds

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }
}


class SmartClock extends Clock implements SampleInterface {

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

    Clock clock = new Clock();
    public long getTimeInSeconds() {
        clock.time = clock.time;
        return this.time / 1000;
    }

    class SampleInnerClass {
        void doSomething() {
            System.out.println("Hello");
        }
    }

}


interface SampleInterface {

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

}

interface A {
    default void foo() { System.out.println("hello from A"); }
    default void zoo(Integer a) { System.out.println("hello from A"); }
   // default void zoo2(Integer a) { System.out.println("hello from A"); }
    default Integer zoo3(Integer a) { System.out.println("hello from A"); return 0;}
}
interface AA {
    default void foo() { System.out.println("hello from A"); }
    default void zoo(Number a) { System.out.println("hello from A"); }
    //default Integer zoo2(Integer a) { System.out.println("hello from A"); return 0;}
    default Number zoo3(Integer a) { System.out.println("hello from A"); return 0;}
}
interface B extends A {
    default void foo() { System.out.println("hello from B"); }
}
interface C extends A {}

class D implements B, C {
    void doSomething() {
        C c = new D();
        c.foo(); // prints 'hello from B'

        B.super.foo();
    }
}

class E implements A, AA {
    @Override
    public void foo() {
        A.super.foo();
    }

    @Override
    public Integer zoo3(Integer a) {
        return A.super.zoo3(a);
    }
}


