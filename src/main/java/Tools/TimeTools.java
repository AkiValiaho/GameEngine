package Tools;

public class TimeTools {
	public static long getCurrentTimeInMillisUsingNanoTime() {
		return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
	}
}