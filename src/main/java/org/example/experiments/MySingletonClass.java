package org.example.experiments;

public class MySingletonClass {

    private int a = 1;
    private static MySingletonClass mySingletonClass;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private MySingletonClass() {
        // No need to write logic, but this must be private
    }

    public static MySingletonClass getMySingletonObject() {
        if(mySingletonClass == null) {
            mySingletonClass = new MySingletonClass();
        }
        return mySingletonClass;
    }
}
