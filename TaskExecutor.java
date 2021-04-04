import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

	public static void main(String[] args) {
		PrintTask task1 = new PrintTask("task1");
		PrintTask task2 = new PrintTask("task2");
		PrintTask task3 = new PrintTask("task3");
		
		System.out.printf("Starting Executor");
		
		ExecutorService execService = Executors.newCachedThreadPool();
		
		execService.execute(task1);
		execService.execute(task2);
		execService.execute(task3);
		
		execService.shutdown();
		
		System.out.printf("Tasks started, main ends.%n%n");
		
	}

}
