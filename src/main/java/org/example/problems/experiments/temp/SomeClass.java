package org.example.problems.experiments.temp;

import org.example.problems.experiments.Clock;

public class SomeClass extends Clock {
    Clock clock = new Clock();
    public long getTimeInSeconds() {
        //clock.time = clock.time; not allowed
        return this.time / 1000;
    }
}

abstract class AbsClass {
    public AbsClass(int i) {
    }
}
class Abc extends AbsClass {

    public Abc(int i) {
        super(i);
    }
}