import java.util.concurrent.TimeUnit;

/**
 * Created by akivv on 15.5.2015.
 */
public class Norttipeli extends Thread {
	private boolean running;

	@Override
	public void run() {
		running = true;
		while (running) {
			long beforeTime, timeDiff, sleepTime;
			beforeTime = getCurrentTimeInMillisUsingNanoTime();
			running = true;
			gameUpdate();
			gameRender();
			paintScreen();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleepTime = 10 - timeDiff;   // time left in this loop
			if (sleepTime <= 0) { // update/render took longer than period      sleepTime = 5;    // sleep a bit anyway
				sleepTime = 5;
			}
			try {
				Thread.sleep(sleepTime);  // in ms    }    catch(InterruptedException ex){}

			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			beforeTime = getCurrentTimeInMillisUsingNanoTime();
		}
	}

	private long getCurrentTimeInMillisUsingNanoTime() {
		return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	private void gameUpdate() {
	}

	private void gameRender() {
	}

	private void paintScreen() {

	}