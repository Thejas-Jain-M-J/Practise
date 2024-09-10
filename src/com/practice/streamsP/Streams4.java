package com.practice.streamsP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

 class Student {
    public String getEmail() {
        return email;
    }

    public Student(String email, String name, int rollNumber, List<String> activities, String grades, double avgMarks) {
        this.email = email;
        this.name = name;
        this.rollNumber = rollNumber;
        this.activities = activities;
        this.grades = grades;
        this.avgMarks = avgMarks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    String name;

    int rollNumber;

    List<String> activities;
    String grades;

    double avgMarks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgMarks() {
        return avgMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", activities=" + activities +
                ", grades='" + grades + '\'' +
                ", avgMarks=" + avgMarks +
                '}';
    }

    public void setAvgMarks(double avgMarks) {
        this.avgMarks = avgMarks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

}
public class Streams4 {

    public static void main(String[] args) {
         List<Student> students = new ArrayList<>();

        students.add(new Student("john.doe@gmail.com", "John Doe", 1, Arrays.asList("Football", "Chess"), "A", 85.5));
        students.add(new Student("jane.smith@yahoo.com", "Jane Smith", 2, Arrays.asList("Basketball", "Music"), "B", 78.0));
        students.add(new Student("alice.jones@hotmail.com", "Alice Jones", 3, Arrays.asList("Drama", "Dance"), "A-", 82.3));
        students.add(new Student("bob.brown@outlook.com", "Bob Brown", 4, Arrays.asList("Science Club", "Robotics"), "B+", 79.5));
        students.add(new Student("charlie.black@aol.com", "Charlie Black", 5, Arrays.asList("Art", "Debate"), "A", 88.0));
        students.add(new Student("david.white@live.com", "David White", 6, Arrays.asList("Football", "Coding"), "B-", 73.5));
        students.add(new Student("emma.green@gmail.com", "Emma Green", 7, Arrays.asList("Swimming", "Basketball"), "A+", 91.0));
        students.add(new Student("frank.lee@yahoo.com", "Frank Lee", 8, Arrays.asList("Music", "Theater"), "C", 65.5));
        students.add(new Student("grace.hall@hotmail.com", "Grace Hall", 9, Arrays.asList("Tennis", "Art"), "B+", 80.7));
        students.add(new Student("henry.adams@outlook.com", "Henry Adams", 10, Arrays.asList("Science Club", "Chess"), "A-", 83.0));
        students.add(new Student("isabel.clark@aol.com", "Isabel Clark", 11, Arrays.asList("Drama", "Dance"), "B", 77.2));
        students.add(new Student("jack.wilson@live.com", "Jack Wilson", 12, Arrays.asList("Football", "Music"), "B+", 80.0));
        students.add(new Student("karen.wright@gmail.com", "Karen Wright", 13, Arrays.asList("Coding", "Robotics"), "A", 86.8));
        students.add(new Student("larry.brown@yahoo.com", "Larry Brown", 14, Arrays.asList("Basketball", "Art"), "C+", 68.5));
        students.add(new Student("mary.johnson@hotmail.com", "Mary Johnson", 15, Arrays.asList("Swimming", "Debate"), "A-", 84.5));


        //printing the unique domains.
        HashSet<String> distinctDOmains = new HashSet<>();
        students.stream()
        .map(student -> student.getEmail())
        .map(email ->  email.substring(email.indexOf('@')))
        .filter(domain -> distinctDOmains.add(domain)).forEach(System.out::println);

    }

}
