package masterClass.MultiThreading.course.virtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceVirtualStarApproach {

	public static void main(String[] args) {
		
//		try with resource
//		by using this approach :-we don't need to join the virtual thread. as since VT are daemon thread
		try(ExecutorService exe = Executors.newVirtualThreadPerTaskExecutor()){
			exe.submit(new VirtualWorkerThread());
			exe.submit(new VirtualWorkerThread());
			exe.submit(new VirtualWorkerThread());
			exe.submit(new VirtualWorkerThread());
		}
		
	}
}
