package org.example.problems.experiments;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {
        List<ParentA> list = new ArrayList<>();
        list.add(new ParentA());
        list.add(new ChildA());

        List<? extends ParentA> list2 = new ArrayList<>();
        // list2.add(new ParentA()); // Error
        // list2.add(new ChildA()); // Error
        // list2.add(new Object()); // Error
        list2.forEach(ParentA::doParentWay);

        List<? super ParentA> list3 = new ArrayList<GrandParentA>();
        list3.add(new ParentA());
        list3.add(new ChildA());
        // list3.add(new Object()); // Error
        // list3.forEach(o -> o.doChildWay()); // Error
    }
}

class GrandParentA {
    public void doGrandParentAWay() {

    }
}

class ParentA extends GrandParentA {
    public void doParentWay() {

    }
}

class ChildA extends ParentA {
    public void doChildWay() {

    }
}