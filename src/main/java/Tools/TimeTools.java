package Tools;

import java.util.concurrent.TimeUnit;

public class TimeTools {
	public static long getCurrentTimeInMillisUsingNanoTime() {
		return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
	}
}