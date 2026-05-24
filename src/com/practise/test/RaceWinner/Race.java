package com.practise.test.RaceWinner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class LapRecord {
    String driverName;
    String checkpoint;
    int time;

    LapRecord(String driverName, String checkPoint, int time) {
        this.driverName = driverName;
        this.checkpoint = checkPoint;
        this.time = time;
    }
}

public class Race {

    public static void main(String[] args) {
        List<LapRecord> lapRecords = new ArrayList<>();
        int checkPointCount = 2;
        int lapCount = 2;
        // checkpoint 1
        lapRecords.add(new LapRecord("Alice", "c-1", 5));
        lapRecords.add(new LapRecord("Bob", "c-1", 3));
        lapRecords.add(new LapRecord("Charlie", "c-1", 1));
        lapRecords.add(new LapRecord("Dave", "c-1", 2));

        // checkpoint 2
        lapRecords.add(new LapRecord("Alice", "c-2", 4));
        lapRecords.add(new LapRecord("Bob", "c-2", 4));
        lapRecords.add(new LapRecord("Charlie", "c-2", 1));

        // Lap 1
        lapRecords.add(new LapRecord("Alice", "L", 6));
        lapRecords.add(new LapRecord("Bob", "L", 4));
        lapRecords.add(new LapRecord("Charlie", "L", 1));

        // checkpoint 1
        lapRecords.add(new LapRecord("Alice", "c-1", 5));
        lapRecords.add(new LapRecord("Bob", "c-1", 3));
        lapRecords.add(new LapRecord("Charlie", "c-1", 1));

        // checkpoint 2
        lapRecords.add(new LapRecord("Alice", "c-2", 4));
        lapRecords.add(new LapRecord("Bob", "c-2", 4));

        // Lap 2
        lapRecords.add(new LapRecord("Alice", "F", 6));
        lapRecords.add(new LapRecord("Bob", "F", 2));
        lapRecords.add(new LapRecord("Charlie", "F", 1));

        Map<String, Integer> winnerMap = new HashMap<>();

        int eliminationCount = (checkPointCount * checkPointCount) + lapCount;
        List<String> eliminatedDrivers = new ArrayList<>();
        eliminatedDrivers = lapRecords.stream()
                .collect(Collectors.groupingBy(i -> i.driverName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() != eliminationCount)
                .map(i -> i.getKey())
                .collect(Collectors.toList());

        winnerMap = lapRecords.stream()
                .collect(Collectors.toMap(i -> i.driverName, i1 -> i1.time, (i1, i2) -> (i1 + i2)));

        for (int i = 0; i < eliminatedDrivers.size(); i++) {
            String driver = eliminatedDrivers.get(i);
            if (winnerMap.containsKey(driver)) {
                winnerMap.remove(driver);
            }
        }

        String winner = winnerMap.entrySet()
                .stream()
                .min(Comparator.comparing(i -> i.getValue()))
                .map(i -> i.getKey())
                .get();

        int temp = 0;
        int lapTime = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < lapRecords.size(); i++) {
            temp = temp + lapRecords.get(i).time;
            count++;
            if (count == (checkPointCount + 1)) {
                count = 0;
                if (temp < lapTime)
                    lapTime = temp;
            }

        }

        System.out.println(winner + ", " + lapTime);

    }

}
