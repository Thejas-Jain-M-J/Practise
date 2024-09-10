package com.practice;
import java.util.*;
public class OcuurenceInArray {

	public static void main(String[] args) {

		String[] abc = {"a","b","c","d","c","a","a"};
		
		HashMap<String,Integer> hMap = new HashMap<String,Integer>(); 
		
		for(int i=0;i<abc.length;i++)
		{
			hMap.put(abc[i], hMap.getOrDefault(abc[i],0)+1);
		}
		
		hMap.entrySet().stream().forEach(i -> System.out.println(i.getKey() + "--"+i.getValue()));
	}

}
