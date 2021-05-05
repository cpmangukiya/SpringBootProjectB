package org.example.experiments;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        System.out.println("Holla");
//
//        MySingletonClass mySingletonClass = MySingletonClass.getMySingletonObject();
//        System.out.println(mySingletonClass.getA());
//        mySingletonClass.setA(2);
//
//
//        MySingletonClass mySingletonClass2 = MySingletonClass.getMySingletonObject();
//        System.out.println(mySingletonClass2.getA());
//
//        Student student1 = new Student();
//        student1.setName("Monika");
//        student1.setAge(25);
//
//        Student student2 = new Student();
//        student2.setName("Monika");
//        student2.setAge(25);

        //Student student2 = student1;

        /*String m1 = new String("Monika");
        String m2 = "Monika";*/
        // m1 == m2; // false
        // m1.equals(m2); //true

//        System.out.println("Are both students same ?");
//        System.out.println(student1.equals(student2));
//
//        System.out.println();
//        System.out.println("Comparable");
//        // Comparable
//        ArrayList arrayList = new ArrayList<Animal>();
//        arrayList.add(new Animal("Dog",4));
//        arrayList.add(new Animal("Bird", 2));
//        arrayList.add(new Animal("Cow",4));
//        arrayList.add(new Animal("Human", 2));
//
//        Collections.sort(arrayList);
//
//        Iterator iterator = arrayList.iterator();
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }
//
//        System.out.println();
//        System.out.println("Comparator");
//        // Comparator
//
//        Collections.sort(arrayList, new MyAnimalComparator());
//
//        iterator = arrayList.iterator();
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }

        ArrayList<Students> obj = new ArrayList<Students>();
        obj.add(new Students(1,"Moni",25));
        obj.add(new Students(2,"Chintz",29));
        obj.add(new Students(3,"Mahi",24));
        obj.add(new Students(4,"Chintu",27));
//        Collections.sort(obj);
//        for(Students st:obj){
//            System.out.println(st.rollNo+ " " + st.name + " " + st.age);
//        }
        Comparator<Students> cm1= Comparator.comparing(Students::getName);
        Collections.sort(obj,cm1);
        System.out.println("Sorting by Name");
        for(Students st: obj){
            System.out.println(st.rollNo+" "+st.name+" "+st.age);
        }
    }
}
