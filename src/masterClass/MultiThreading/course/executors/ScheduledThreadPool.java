package masterClass.MultiThreading.course.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
Run a task at a scheduled time.

Run a task repeatedly after some fixed delay.

Useful for periodic jobs like cleanup, monitoring, email check, cache refresh, or heartbeat tasks
 */
class StockMarketPricUpdater implements Runnable{

	@Override
	public void run() {
		System.out.println("Running the Stock Market Get Api from the Web.." +  LocalDateTime.now());
	}
	
}


public class ScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(new StockMarketPricUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);
	}

}
