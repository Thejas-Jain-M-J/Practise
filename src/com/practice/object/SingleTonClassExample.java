package com.practice.object;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author tjainmj
 *         singleton class example
 *
 *         <------ create on static variable of type class ----->
 *         <------ create static method and return singleObj ------->
 *         <------ Make constructor as private ------->
 *         <------ Adding volatile keyword because To make thread updates to
 *         main memory -------->
 *
 *
 *         In singleton class if two threads try to access this class there may
 *         be chance
 *         that two objects may be created. so we need to synchronize this one
 *         by applying
 *         synchronization to the method oe to the object creation block.
 *
 */

class SingleTon {

	private static volatile SingleTon singleObj = null;

	private SingleTon() {
	}

	public static synchronized SingleTon getObject() {
		// synchronized(SingleTon.class) {
		if (singleObj == null) {
			singleObj = new SingleTon();
		}
		// }

		return singleObj;
	}
}

public class SingleTonClassExample {

	public static void main(String[] args) {

		// we need to make constructor as private so outside of the class object will
		// not be created.
		// SingleTon c = new SingleTon();

		ExecutorService es = Executors.newFixedThreadPool(2);
		Runnable r1 = () -> {
			System.out.println(SingleTon.getObject().hashCode());
		};

		Runnable r2 = () -> {
			System.out.println(SingleTon.getObject().hashCode());
		};

		es.submit(r1);
		es.submit(r2);
		es.shutdown();

		SingleTon a = SingleTon.getObject();
		SingleTon b = SingleTon.getObject();

		// System.out.println(r1.hashCode() +" "+r2.hashCode() );
		System.out.println(a.hashCode() + " " + b.hashCode());

	}

}
