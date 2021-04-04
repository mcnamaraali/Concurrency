import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {

	public static void main(String[] args) {
		
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(1, sharedSimpleArray);
		
		ExecutorService execService = Executors.newCachedThreadPool();
		execService.execute(writer1);
		execService.execute(writer2);
		
		execService.shutdown();
		
		try {
			boolean tasksEnded = execService.awaitTermination(1, TimeUnit.MINUTES);
			
			if(tasksEnded) {
				System.out.printf("%nContexts of SimpleArray%n");
				System.out.println(sharedSimpleArray);
			}
			else {
				System.out.println("Timed out while waiting for tasks to finish.");
			}
	
		}
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
