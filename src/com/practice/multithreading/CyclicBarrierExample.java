package com.practice.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Here we use cyclic barrier to make all threads synchronize. Means to come at
 * the same point
 * If we call cyclicBarrier.await() on each method. Then at that level all
 * threads will wait for all threads
 * to reach that point.
 * Means if we call on that each thread the all thread will pause execution at
 * that level.
 * Once it all came to same point them execution will resume.
 */

public class CyclicBarrierExample {
	private static final int NUM_PLAYERS = 5;
	private static final int SEGMENT_DISTANCE = 100; // Distance of each segment
	private static final CyclicBarrier startLine = new CyclicBarrier(NUM_PLAYERS);
	private static final CyclicBarrier finishLine = new CyclicBarrier(NUM_PLAYERS);

	public static void main(String[] args) {
		for (int i = 0; i < NUM_PLAYERS; i++) {
			Thread player = new Thread(new Player(i));
			player.start();
		} 
	}

	static class Player implements Runnable {
		private final int id;

		public Player(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				System.out.println("Player " + id + " is ready at the start line.");
				startLine.await(); // Wait for all players to be ready
				System.out.println("Player " + id + " starts running.");

				// Simulate running the segment
				Thread.sleep((id + 1) * 100); // Simulate each player running at different speeds

				System.out.println("Player " + id + " reached the finish line.");
				finishLine.await(); // Wait for all players to finish the segment
				System.out.println("Everyone reached here");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

}
