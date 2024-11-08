package com.practice.streamsP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        students.add(
                new Student("jane.smith@yahoo.com", "Jane Smith", 2, Arrays.asList("Basketball", "Music"), "B", 78.0));
        students.add(
                new Student("alice.jones@hotmail.com", "Alice Jones", 3, Arrays.asList("Drama", "Dance"), "A-", 82.3));
        students.add(new Student("bob.brown@outlook.com", "Bob Brown", 4, Arrays.asList("Science Club", "Robotics"),
                "B+", 79.5));
        students.add(
                new Student("charlie.black@aol.com", "Charlie Black", 5, Arrays.asList("Art", "Debate"), "A", 88.0));
        students.add(
                new Student("david.white@live.com", "David White", 6, Arrays.asList("Football", "Coding"), "B-", 73.5));
        students.add(new Student("emma.green@gmail.com", "Emma Green", 7, Arrays.asList("Swimming", "Basketball"), "A+",
                91.0));
        students.add(new Student("frank.lee@yahoo.com", "Frank Lee", 8, Arrays.asList("Music", "Theater"), "C", 65.5));
        students.add(
                new Student("grace.hall@hotmail.com", "Grace Hall", 9, Arrays.asList("Tennis", "Art"), "B+", 80.7));
        students.add(new Student("henry.adams@outlook.com", "Henry Adams", 10, Arrays.asList("Science Club", "Chess"),
                "A-", 83.0));
        students.add(
                new Student("isabel.clark@aol.com", "Isabel Clark", 11, Arrays.asList("Drama", "Dance"), "B", 77.2));
        students.add(
                new Student("jack.wilson@live.com", "Jack Wilson", 12, Arrays.asList("Football", "Music"), "B+", 80.0));
        students.add(new Student("karen.wright@gmail.com", "Karen Wright", 13, Arrays.asList("Coding", "Robotics"), "A",
                86.8));
        students.add(new Student("larry.brown@yahoo.com", "Larry Brown", 14, Arrays.asList("Basketball", "Art"), "C+",
                68.5));
        students.add(new Student("mary.johnson@hotmail.com", "Mary Johnson", 15, Arrays.asList("Swimming", "Debate"),
                "A-", 84.5));

        // printing the unique domains.
        HashSet<String> distinctDOmains = new HashSet<>();
        students.stream()
                .map(student -> student.getEmail())
                .map(email -> email.substring(email.indexOf('@')))
                .filter(domain -> distinctDOmains.add(domain)).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------");

        /**
         * Print the String in reverse order " Thejas is Name My";
         * output : My Name is Thejas
         */

        String str = " Thejas is Name My";

        String[] words = str.split(" ");

        String resultString = Arrays.stream(words)
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                    Collections.reverse(lst);
                    return lst.stream();
                })).collect(Collectors.joining(" "));

        System.out.println("resultString " + resultString);
        String result = IntStream.range(0, words.length).mapToObj(i -> words[words.length - 1 - i])
                .collect(StringBuilder::new,
                        (sb, word) -> {
                            if (sb.length() > 0)
                                sb.append(" ");

                            sb.append(word);
                        }, StringBuilder::append)
                .toString();

System.out.println(result);
        System.out.println("---------------------------------------------------------------------");

        /**
         * FInd how many numbers are there still Number N.
         * input: 13
         * output: 6
         *
         * Long totalOnes = IntStream.range(0, n)
         * .boxed()
         * .map(i -> String.valueOf(i)) // Convert each int to String
         * .filter(i -> i.contains("1")) // Filter strings that contain "1"
         * .mapToLong(i -> i.chars() // Convert the string to a stream of characters
         * .filter(ch -> ch == '1') // Filter only '1' characters
         * .count()) // Count the '1's in the string
         * .sum(); // Sum up the counts
         *
         * This solution without using flat map
         * If we have string then if we want iterate we can use str.chars()
         */

        int n = 14;

        Long totalOnes = IntStream.range(0, n)
                .boxed()
                .map(i -> String.valueOf(i))
                .filter(i -> i.contains("1"))
                .map(i -> i.split(""))
                .flatMap(i -> Stream.of(i))
                // .peek(i->System.out.println(i) )
                .filter(i -> i.contains("1"))
                .count();

        System.out.println("totalOnes " + totalOnes);
        System.out.println("---------------------------------------------------------------------");

        /**
         * Find the student whose avg marks greater than 86.
         */

        Student studWithAverage = students.stream()
                .filter(stud -> stud.avgMarks > 86)
                .findFirst()
                .orElse(null);

        System.out.println(" studWithAverage " + studWithAverage);
        System.out.println("---------------------------------------------------------------------");

        // flat map to int

        Stream<String> strings = Stream.of("1,2,3", "4,5");
        IntStream intStream = strings.flatMapToInt(s -> Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt));

        intStream.forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("---------------------------------------------------------------------");

        /**
         * Print second highest number in array
         * 
         * Here first sorting collects all the data and it applies some sorting
         * algorithm\
         * and then it starts returning the sorted data one by one. Bit different than
         * other
         * intermediatory operations.
         */

        int[] arr = { 1, 45, 36, 52, 75, 71, 18, 81 };

        Optional<Integer> secondHighest = Arrays.stream(arr)
                .boxed()
                // .peek(i -> System.out.println("before "+i))
                .sorted((i1, i2) -> {
                    if (i1 > i2)
                        return -1;
                    else if (i1 < i2)
                        return 1;
                    else
                        return 0;
                })
                // .peek(i -> System.out.println("after "+i))
                .skip(1)
                .findFirst();

        System.out.println("secondHighest " + secondHighest);

        // i/p: orange, apple, mango
        // o/p: Orange, Apple, Mango

        String[] strArr = {"orange", "apple", "mango"};
        
        Arrays.stream(strArr)
        .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
        .forEach(word -> System.out.println(word));

    }

}
