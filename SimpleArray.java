import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
	private static final SecureRandom random = new SecureRandom();
	private final int[] array;
	private int writeIndex;
	
	public SimpleArray(int size) {
		array = new int[size];
	}
	
	public synchronized void add(int value) {
		int position = writeIndex;
		try {
			Thread.sleep(random.nextInt(500));		
			}
		catch (InterruptedException ex) {
			Thread.currentThread().interrupt(); //re-interrupt the thread
		}
		
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.%n", Thread.currentThread().getName(), value, position);
		
		++writeIndex;
		System.out.printf("Next write index: %d%n", writeIndex);
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	
}
