package commons;

public class GlobalConstants {

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
}