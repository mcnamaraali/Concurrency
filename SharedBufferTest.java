import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

	public static void main(String[] args) throws InterruptedException {
		//create new thread pool
		ExecutorService  execService = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new UnsynchronisedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.printf("------\t\t------\t---------------\t---------------%n%n");
		
		execService.execute(new Producer(sharedLocation));
		execService.execute(new Consumer(sharedLocation));
		
		execService.shutdown();
		execService.awaitTermination(1, TimeUnit.MINUTES);

	}

}
