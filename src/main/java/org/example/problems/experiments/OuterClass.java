package org.example.problems.experiments;

import java.util.List;

public class OuterClass {

    private String instanceValue;
    private static String staticValueP = "1";
    private List<int[]> list;

    public void doSomething() {
        class InnerClass4 {
            InnerClass1 innerClass1 = new InnerClass1();
            //static String staticValue122 = "1";
            static final String staticValue = "1";
            String staticValue23 = OuterClass.staticValueP;
            public void doSm() {
                System.out.println(instanceValue);
            }
        }
    }

    public class InnerClass1 {
        InnerClass2 innerClass2 = new InnerClass2();
        //static String staticValue = "1";
        static final String staticValue2 = "1";
         public void doSm() {
             System.out.println(instanceValue);
         }
    }

    private class InnerClass2 {
        InnerClass1 innerClass1 = new InnerClass1();

        public void doSm() {
            System.out.println(instanceValue);
            System.out.println(InnerClass3.staticValue233);
        }
    }

    protected static class InnerClass3 {
        //InnerClass1 innerClass1 = new InnerClass1();
        String staticValue23 = OuterClass.staticValueP;
        static String staticValue233 = OuterClass.staticValueP;
        static final String staticValue2233 = OuterClass.staticValueP;
        public void doSm() {
            System.out.println(staticValueP);
        }
    }
}

class AnotherClass {
    OuterClass.InnerClass3 innerClass3 = new OuterClass.InnerClass3();
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass1 innerClass1 = outerClass.new InnerClass1();
}

class Shape{
    public static void draw()
    {
        System.out.println("Shape");
    }
}

class Circle extends Shape{
    public static void draw()
    {
        System.out.println("Circle");
    }
}

class PumpkinDemo {

    public static void main(String[] args){
        Parent p = new Child();
        p.testMethod(0);
    }
}

class Parent{
    public void testMethod(Number n)
    {
        System.out.println("Parent");
    }
}

class Child extends Parent{

    public void testMethod(Integer n)
    {
        System.out.println("Child");
    }
}