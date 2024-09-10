package com.practice;

public class ClosetCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "hhackerrankjjjjjjjjjjjjjjjjjk";
		int arr[] = {0,4,7,9};
		       //o/p:-1,-1,6, 3
		
		
		for(int i=0;i<arr.length;i++)
		{
			int index=arr[i];
			int rightToElement= s.indexOf(s.charAt(index),index+1);
		
				
		    int leftToElement= s.substring(0,index).lastIndexOf(s.charAt(index));

			
			if(rightToElement == -1)
			{
				System.out.println(leftToElement);
			}else if(leftToElement == -1)
			{
				System.out.println(rightToElement);
			}else
			{
			System.out.println((index-leftToElement)<=(rightToElement-index) ? leftToElement :rightToElement);
			}
		}
		
	}

}
