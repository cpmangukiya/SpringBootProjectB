package org.example.experiments;


public class Animal implements Comparable {

    private String type;
    private Integer legs;

    public Animal(String type, Integer legs) {
        this.type = type;
        this.legs = legs;
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
