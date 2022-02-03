package com.step.jdbc;

public class Employee {
    private int id;
    private  String name;
    private String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(int id, String name, String surname) {
        this(name, surname);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void setName() {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
