package com.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is Example of comparable, here we need to override the class by
 * extending comparable
 * interface. Here we can only have natural ordering means we can sor based on
 * any one criteria. If we have multiple criteria to solve then we need to go
 * for comparator.
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Implement the compareTo method from Comparable
    @Override
    public int compareTo(Person other) {
        // Compare by age
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

/**
 * This example of comparator here we can create comparator outside of class we
 * can sort
 * based on as many criteria. we can create comparator outside of class without
 * modifying
 * the model class.
 */
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

// Comparator to sort by name
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee p1, Employee p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

// Comparator to sort by age
class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee p1, Employee p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

public class comparator__comparable {

    public static void main(String[] args) {

        // comparable Example
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort using natural ordering (by age)
        Collections.sort(people);

        people.forEach(System.out::println);

        // comparator Example

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Alice", 30));
        emp.add(new Employee("Bob", 25));
        emp.add(new Employee("Charlie", 35));

        // Sort by name (using Comparator)
        emp.sort(new NameComparator());
        System.out.println("Sorted by Name:");
        emp.forEach(System.out::println);

        // Sort by age (using Comparator)
        emp.sort(new AgeComparator());
        System.out.println("\nSorted by Age:");
        emp.forEach(System.out::println);

    }

}
