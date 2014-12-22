package com.assignment.model;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestLauncher {
	@Test
	public void runner() {
		// PerformanceTest ptest = new PerformanceTest();
		Vector<Double> loadTimes = new Vector<Double>();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Runnable ptest = new PerformanceTest(loadTimes);
			executor.execute(ptest);
		}
		executor.shutdown();
		while(!executor.isTerminated()){}
	}
}
