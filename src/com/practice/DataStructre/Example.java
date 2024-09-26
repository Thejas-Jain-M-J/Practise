package com.practice.DataStructre;

import java.util.HashMap;

public class Example {

    public static void main(String[] args) {
        String[][] values = {  { "Bobby", "87" } , { "Charles", "100" } , { "Eric", "64" } ,{ "Charles", "22" } };
        System.out.println(bestAverageGrade(values))        ;
     }
    public static Integer bestAverageGrade(String[][] scores) { 
        HashMap<String,int[]> hmap = new HashMap<>();
        int highestGrade = Integer.MIN_VALUE;
        for(String[] value : scores )
        {
            String name = value[0];

            if(hmap.containsKey(name))
            {
               int [] arr = hmap.get(name);
               arr[0] += Integer.parseInt(value[1]);
               arr[1]++;
               hmap.put(name,arr);

            }else{
                int[] gradeArray = new int[2];
                gradeArray[0] = Integer.parseInt(value[1]);
                gradeArray[1] = 1;
                hmap.put(name,gradeArray);
            }
        }

        for(int[] arr : hmap.values())
        {
            int averageOfGrades = arr[0]/arr[1];
            if(averageOfGrades > highestGrade)
            {
                highestGrade = averageOfGrades;
            }
        }
        return highestGrade;
    } 

}
