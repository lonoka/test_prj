package thread;

public class run_thread extends Thread {
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				System.out.println("Thread µø¿€ ¡ﬂ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
