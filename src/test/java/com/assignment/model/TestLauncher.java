package com.assignment.model;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestLauncher {
	
	private final int USERS = 50;
	
	@Test
	public void runner() {
		long start_time=System.currentTimeMillis();
		Vector<Long> loadTimes = new Vector<Long>();
		ExecutorService executor = Executors.newFixedThreadPool(USERS);
		for (int i = 0; i < USERS; i++) {
			Runnable ptest = new PerformanceTest(loadTimes);
			executor.execute(ptest);
		}
		executor.shutdown();
		while(!executor.isTerminated()){}
		long end_time=System.currentTimeMillis();
		long total = 0;
		for(long i : loadTimes){
			total += i;
		}
		
		System.out.println("Total execution time for the test: "+(start_time-end_time));
		
		System.out.println("Average response time per page: " + total/loadTimes.size());
	}
}
