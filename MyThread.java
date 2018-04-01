import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

	private int type;
	private volatile IResource resource;
	private Semaphore semaphore;

	public MyThread(int type, IResource resource, Semaphore semaphore) {
		this.type = type;
		this.resource = resource;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		while (true) {
			if (resource.isUnused()) {
				setType();
			}

			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (resource.isUsedBy(type) && resource.canBeUsed()) {
				useResourse();
				if(type == 1) {
					System.out.println("Resource used by white");
				}else {
					System.out.println("Resource used by black");
				}
				
				releaseResourse();
			}
			semaphore.release();
		}

	}

	private void setType() {
		resource.setType(type);
	}

	private void releaseResourse() {
		resource.isReleased();
	}

	private void useResourse() {
		try {
			sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resource.isUsed();

	}

}
