package masterClass.MultiThreading.course.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SingleThreadLogic implements Runnable{
    private int taskId;
    
    public SingleThreadLogic(int taskId){
        this.taskId = taskId;
    }
    
    @Override
    public void run(){
        System.out.println("Currently Running Thread :- "+ Thread.currentThread().getName() + " and Task Id :- "+ this.taskId);
        long duration = (long) Math.random()* 5;
        try{
        TimeUnit.SECONDS.sleep(duration);
        System.out.println("Completed " + this.taskId);
        }catch(Exception ex){
            
        }
    }
}

public class SingleThreadExecutor {
	public static void main(String[] args) {
//		create a single thread 
//		useful in when we want to execute multiple task synchronously in order they have submitted. create a single thread that run task in background.
        ExecutorService exeSer= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            exeSer.submit(new SingleThreadLogic(i));
        }
        exeSer.shutdown();
    }
}
