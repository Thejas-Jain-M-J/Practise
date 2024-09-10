package com.practice.stack;
import java.util.*;
public class NGE {

	public static void main(String[] args) {
		
        int arr[] = {4,2,3,2,1};
		Stack s = new Stack<Integer>();
		
		s.push(arr[0]);
		
		for(int i=1;i<arr.length;i++)
		{
			int next = arr[i];
			
			int element = (int) s.pop();
			//System.out.println("i" +i+ " element " +element  +"next "+next);
			
			while(element<next)
			{
				System.out.println("cur -> "+element +"  next -> "+next);
				
				//System.out.println(s.size());
				
				if(s.isEmpty())
				{
					break;
				}
				element = (int) s.pop();
			}
			
			if(element>next)
			{
				s.push(element);
			}
			
			s.push(next);
			
			
			
		}
		
		
		while (!s.isEmpty())
		{
			System.out.println("cur -> "+s.pop() +"  next -> "+"-1");
		}
		
		
		
	}

}
