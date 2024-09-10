package com.practice;

import java.util.HashMap;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 4,5,2,3,1,6    ||  o/p:5
		
		
		
//		int arr[] = {10,11,45,23,67,46};
//		
//		int fh=arr[0];
//		int sh=0;
//		for(int i=1;i<arr.length;i++)
//		{
//			if(arr[i]>fh)
//			{
//				sh=fh;
//				fh=arr[i];
//			}
//			else if(arr[i]>sh)
//			{
//				sh=arr[i];
//			}
//		}
//		
//		System.out.println("second highest "+sh);
		
		//infinite
		
		String str="infinite";
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			hmap.put(str.charAt(i), hmap.getOrDefault(str.charAt(i),0)+1);
//			if(hmap.containsKey(str.charAt(i)))
//			{
//				//int j=hmap.get(str.charAt(i));
//				
//				hmap.put(str.charAt(i),hmap.get(str.charAt(i)+1));
//			}else
//			{
//				hmap.put(str.charAt(i), 1);
//			}
		}

		hmap.entrySet().forEach(System.out::print);
	}

}
