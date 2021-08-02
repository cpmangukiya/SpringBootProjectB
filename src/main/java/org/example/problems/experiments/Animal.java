package org.example.problems.experiments;


import java.util.ArrayList;
import java.util.List;

public class Animal implements Comparable {

    private String type;
    private Integer legs;

    public Animal(String type, Integer legs) {
        this.type = type;
        this.legs = legs;
    }

    public Animal() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public String toString(){
        return this.getType()+" "+this.getLegs();
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Animal)) {
            return 0;
        }
        Animal animal = (Animal) o;
        if(this.getType().compareTo(animal.getType()) > 0){
            return 1;
        }
        if(this.getType().compareTo(animal.getType()) < 0){
            return -1;
        }
        return 0;
    }
}

class Cat extends Animal {

    public Cat(String type, Integer legs) {
        super(type, legs);
    }

    public Cat() {
        super();
    }

    public static void demo(Animal animal) {

    }
}

class SampleClass {
    public static void main(String[] args) {
        List<? extends Animal> list2 = new ArrayList<Animal>();
        List<? super Cat> list = new ArrayList<Cat>();
        list.add(new Cat());
        list.add(new Cat());
        //list = list2;
        Cat.demo(new Cat());
    }
}