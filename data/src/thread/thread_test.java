package thread;

public class thread_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		run_thread goThread = new run_thread();
		goThread.start();
		
		System.out.println("현재 스레드가 실행되고있습니다.");
		Thread.sleep(3000);
		goThread.interrupt();
		System.out.println("스레드 종료");
	}

}
