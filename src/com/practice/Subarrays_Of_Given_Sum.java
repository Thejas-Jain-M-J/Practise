package com.practice;

public class Subarrays_Of_Given_Sum {

	public static void main(String[] args) {
		
		int arr[] = {3,4,8,6,1,2,9};
		int sum=0;
		int value=14;
		int start=0;
		
		
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
			
			while(sum>value)
			{
				sum=sum-arr[start];
				start++;
			}
			
			if(sum==value)
			{
				System.out.println(start+"  "+ i);
				break;
			}
		}
		
		
	}

}
