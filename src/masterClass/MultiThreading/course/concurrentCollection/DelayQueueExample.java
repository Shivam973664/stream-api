package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// we have created custom class implements Delayed interface which will track the duration
// then we have delayedQUeue which will maintain orders of elements based on there delay
// Delay Queue implements Blocking Queue
// we can make this example by creating multiple thread which will insert in this queue
// since it is thread safe it will not be a problem.
class CustomDelayQueue implements Delayed{

	private long duration;
	private String message;
	
	public CustomDelayQueue(long duration, String message) {
		this.duration = System.currentTimeMillis() + duration;
		this.message = message;
	}
	
	@Override
	public int compareTo(Delayed o) {
		CustomDelayQueue other= (CustomDelayQueue)o;
		if(this.duration< other.duration) {
			return -1;
		}else if(this.duration> other.duration) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		
		return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomDelayQueue [duration=" + duration + ", message=" + message + "]";
	}
	
}


public class DelayQueueExample {

	public static void main(String[] args) {
		BlockingQueue<CustomDelayQueue> blockingQueue= new DelayQueue<CustomDelayQueue>();
//		
		try {
			blockingQueue.put(new CustomDelayQueue(2000,"This is the first message"));
			blockingQueue.put(new CustomDelayQueue(3000,"This is the Second message"));
			blockingQueue.put(new CustomDelayQueue(4500,"This is the Third message"));
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//we can get the messages
		while(!blockingQueue.isEmpty()) {
			try {
				System.out.println(blockingQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
