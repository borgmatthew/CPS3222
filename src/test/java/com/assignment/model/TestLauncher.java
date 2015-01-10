package com.assignment.model;

import java.net.UnknownHostException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.Test;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;
import com.mongodb.MongoClient;

public class TestLauncher {
	
	private final int USERS = 5;
	private AtomicBoolean allThreadsStarted = new AtomicBoolean(false);
	private AtomicInteger browsersOpened = new AtomicInteger(0);
	
	@Test
	public void runner() {
		long start_time=System.currentTimeMillis();
		Vector<Long> loadTimes = new Vector<Long>();
		AtomicInteger atomicInteger = new AtomicInteger(0);
		ExecutorService executor = Executors.newFixedThreadPool(USERS);
		for (int i = 0; i < USERS; i++) {
			Runnable ptest = new PerformanceTest(loadTimes, atomicInteger, allThreadsStarted, browsersOpened, USERS);
			executor.execute(ptest);
		}
		allThreadsStarted.set(true);
		executor.shutdown();
		while(!executor.isTerminated()){}
		long end_time=System.currentTimeMillis();
		long total = 0;
		for(long i : loadTimes){
			total += i;
		}
		
		System.out.println("Total execution time for the test: "+(end_time - start_time));
		
		System.out.println("Average response time per page: " + total/loadTimes.size());
	}
	
	@After
	public void deleteUserData() throws UnknownHostException{
		User user = new User();
		Bet bet = new Bet();
		MongoClient client = new MongoClient("localhost", 27017);
		client.getDB("SoftwareTesting").getCollection("Users").remove(user);
		client.getDB("SoftwareTesting").getCollection("Bets").remove(bet);
		client.close();
	}
}
