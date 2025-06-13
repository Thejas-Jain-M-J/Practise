package com.practice.object;

import java.util.HashMap;
import java.util.HashSet;

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    // @Override
    public boolean equals(Object obj) {
        System.out.println("obj  " + obj.hashCode() + "  this " + this.hashCode());
        // System.out.println("obj "+this.hashCode());
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

    // commented
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}

class ClientTest {
    public static void main(String[] args) {
        Employee employee = new Employee("rajeev", 24);
        Employee employee1 = new Employee("rajeev1", 25);
        Employee employee2 = new Employee("rajeev", 24);

        HashSet<Employee> employees = new HashSet<Employee>();
        HashMap<Employee, Employee> emp1 = new HashMap<Employee, Employee>();
        System.out.println("hashcode ::::" + employees.hashCode());
        emp1.put(employee, employee);
        emp1.put(employee2, employee2);

        // System.out.println(emp1.get(employee).age);

        employees.add(employee);
        employees.add(employee2);
        employees.add(employee1);

        employees.forEach((k) -> System.out.println("k " + k.hashCode() + " " + k.name));

        System.out.println("Hash Set size: " + employees.size());


        //This below 3 lines will print hash size equal to 3 because we changed object and 
        //adding it to set
       // employee2 = new Employee("rajeev2", 24);
        // employees.add(employee2);
        // System.out.println("After Hash Set size: "+employees.size());


        //but only with below line chsnfe hash set size will not change until we re insert.
        employee2.name = "rajeev2";
        employees.add(employee2);
        System.out.println("After Hash Set size: "+employees.size());

        // System.out.println("employee.hashCode(): " + employee.hashCode()
        // + " employee2.hashCode():" + employee2.hashCode());

    }
}

class A {
    private int abc;

    A(int abc) {
        this.abc = abc;
    }
}

class B {
    public void add() {
        A a = new A(1);
    }
}