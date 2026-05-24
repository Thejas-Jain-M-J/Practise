package com.practice.object;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Distinct only works if equals and object method is overridden in the model class.
 * 
 * contract of equals and hashcode
 * 1. If two objects are equal then their hashcode must be same.
 * 2. If two objects have same hashcode then they are not necessarily equal.
 * 3. If equals method is overridden then hashcode must be overridden.
 */
 class User {
    private int id;
    private String name;
    private int age;
    private String email;

    // Constructors
    public User() {}

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }

    // equals and hashCode (based on name and age for distinct logic)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // Optional: toString
    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " - " + email;
    }
}

public class UnionOfList {

    public static List<User> unionOfList(List<User> userFromDB, List<User> userFromApi) {
        return Stream.concat(userFromDB.stream(), userFromApi.stream())
                .distinct() // requires User to have equals & hashCode
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getAge))
                .collect(Collectors.toList());
    }

    // Demo usage
    public static void main(String[] args) {
        List<User> dbList = Arrays.asList(
                new User(1, "Alice", 30, "alice@example.com"),
                new User(2, "Bob", 25, "bob@example.com")
        );

        List<User> apiList = Arrays.asList(
                new User(3, "Alice", 30, "alice@api.com"), // duplicate based on name + age
                new User(4, "Charlie", 28, "charlie@example.com")
        );

        List<User> result = unionOfList(dbList, apiList);
        result.forEach(System.out::println);
}
}
