package com.practice.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tjainmj
 *
 *Immutable class example 
 *<------ Make class as final so subclass can't extend this one and can't override it   ----->
 *<------ Don't provide setters. Give only getters. ----->
 *<------ Make all variables as private final. so it can't be modified. ----->
 *<------ No need to make constructor private ----->
 *
 */

  final class ImmutableClass {

	private final  List<Integer> l = new ArrayList<Integer>();
	private final int a=20;
	
//	ImmutableClass(int a)
//	{
//		this.a=a;
//	}
	public  void a()
	{
		
		 l.add(a);
		 l.add(2);
		 
		 System.out.println(l);
	}

	public void afterModification()
	{
		System.out.println(l);
	}
	public List<Integer> getL() {
		return Collections.unmodifiableList(l);
	}

	 
	
}

class ImmutableClassExample
{
	

	
	
	public static void main(String args[])
	{
		ImmutableClass i = new ImmutableClass();
		 i=new ImmutableClass();
		i.a();
		List<Integer> list=i.getL();
//		list.add(3);
//		list.add(4);
		i.afterModification();
	}
}
