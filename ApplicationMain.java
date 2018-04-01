import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ApplicationMain {
	private int maxUsersNumber = 3;
	private IResource resource = new Resource(maxUsersNumber );
	private ArrayList<Thread> threadsList = new ArrayList<Thread>();
	private Semaphore semaphore = new Semaphore(maxUsersNumber);
	
	public static void main(String[] args) {
		new ApplicationMain().start();
	}

	private void start() { 
		Thread whiteThread1 = new MyThread(1, resource, semaphore);
		Thread whiteThread2 = new MyThread(1, resource, semaphore);
		Thread whiteThread3 = new MyThread(1, resource, semaphore);

		
		Thread blackThread1 = new MyThread(0, resource, semaphore);
		Thread blackThread2 = new MyThread(0, resource, semaphore);
		Thread blackThread3 = new MyThread(0, resource, semaphore);
		
		threadsList.add(whiteThread1);
		threadsList.add(blackThread1);
		threadsList.add(blackThread2);
		threadsList.add(whiteThread3);
		threadsList.add(whiteThread2);
		threadsList.add(blackThread3);
		
		startThreads();
		joinThreads();
	}

	private void joinThreads() {
		for (Thread thread : threadsList) {
			thread.start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void startThreads() {
		for (Thread thread : threadsList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
