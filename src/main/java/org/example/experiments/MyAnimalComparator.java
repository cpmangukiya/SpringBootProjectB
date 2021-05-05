package org.example.experiments;

import java.util.Comparator;

public class MyAnimalComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Animal animal1 = (Animal) o1;
        Animal animal2 = (Animal) o2;
        if(animal1.getLegs().compareTo(animal2.getLegs()) > 0){
            return 1;
        }
        if(animal1.getLegs().compareTo(animal2.getLegs()) < 0){
            return -1;
        }
        return 0;
    }
}
