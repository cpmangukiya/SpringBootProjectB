package org.example.experiments;

public class Student extends Object {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Student)) {
            return false;
        }
        Student student = (Student) object;
        if(this.getName().equals(student.getName()) && this.getAge() == student.getAge()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : name.hashCode());
        result = prime * result + ((this.age == null) ? 0 : age.hashCode());
        return result;
    }

}
