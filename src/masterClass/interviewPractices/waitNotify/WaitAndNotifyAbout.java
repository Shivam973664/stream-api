package masterClass.interviewPractices.waitNotify;

///more about threads are in javaAdditionalConceptPractice
public class WaitAndNotifyAbout {

	public static void main(String[] args) {
		Message msg = new Message();
		Thread t1 = new Thread(() -> {
			String[] messages = { "Read", "about", "the", "books" };
			for (String bean : messages) {
				msg.write(bean);
				System.out.println("Message has been writed : " + bean);
				try {
					Thread.sleep(500);
				} catch (InterruptedException exc) {
					Thread.currentThread().interrupt();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 4; i++) {
				String message = msg.read();
				System.out.println("Message Readed is : " + message);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		t1.start();
		t2.start();
	}

}

class Message {
	private String message;
	private boolean empty = true;

	public synchronized String read() {
		while (empty) {
			try {
				wait();// Wait until message is written
			} catch (InterruptedException exc) {
				Thread.currentThread().interrupt();
			}
		}
		empty = true;
		notifyAll();// Notify that message has been consumed
		return message;

	}

	public synchronized void write(String message) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException exc) {
				Thread.currentThread().interrupt();
			}
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}