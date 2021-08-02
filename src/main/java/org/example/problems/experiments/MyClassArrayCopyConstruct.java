package org.example.problems.experiments;

import org.apache.tomcat.jni.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClassArrayCopyConstruct {
    public static void main(String args[]) {
        List<Integer> ints1 = new ArrayList<>(Arrays.asList(0,1,2));
        System.out.println(ints1);
        List<Integer> ints2 = ints1;
        ints2.set(0,0+10);
        System.out.println(ints1);
        List<Integer> ints3 = new ArrayList<>(ints1);
        ints3.set(1,1+10);
        System.out.println(ints1);
        System.out.println(ints3);

        List<Student> list1= new ArrayList<>(
                Arrays.asList(new Student("Abc"),new Student("Xyz"),new Student("Pqs")));
        System.out.println(list1);
        List<Student> list2 = list1;
        list2.set(0,new Student("Abc",1,1,new Standard(1)));
        System.out.println(list1);
        List<Student> list3 = new ArrayList<>(list1);
        list1.set(1,new Student("Abc",3,3,new Standard(3)));
        list1.get(0).getStandard().setClassValue(4);
        System.out.println(list1);
        System.out.println(list3);
    }
}
