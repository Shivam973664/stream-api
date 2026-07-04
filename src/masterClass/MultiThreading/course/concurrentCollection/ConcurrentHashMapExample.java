package masterClass.MultiThreading.course.concurrentCollection;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

//Locking granularity: locks are per-bucket (not global), so writes on different buckets run in parallel.
//Reads: most reads are lock-free and don’t block.
//Writes: updates/inserts/removals synchronize at the bucket level, reducing contention.
//Bucket structure: buckets start as linked lists and convert to red‑black trees when long (threshold ≈ 8) to keep lookups fast.
//Safety & takeaway: implementation uses volatile, CAS, and fine-grained sync (resizing is coordinated) — use ConcurrentHashMap for high-concurrency read/write workloads. 
class WorkerOfMap implements Runnable {

	private Map<Integer, Integer> map;
	
	private Random random = new Random();
	
	public WorkerOfMap(Map<Integer, Integer> map) {
		this.map = map;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				map.put(random.nextInt(1000), random.nextInt(1000));
				System.out.println("map " + map);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


public class ConcurrentHashMapExample {

	public static void main(String[] args) {
//		the example is same
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		new Thread(new WorkerOfMap(map)).start();
		new Thread(new WorkerOfMap(map)).start();
		new Thread(new WorkerOfMap(map)).start();
		
		map.forEach((a,b)-> System.out.println(a + " " +b));
		
	}
}
