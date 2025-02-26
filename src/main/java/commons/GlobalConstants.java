package commons;

public class GlobalConstants {

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	public static final String ADMIN_PAGE_URL = "http://live.techpanda.org/index.php/backendlogin";
	public static final String USER_PAGE_URL = "http://live.techpanda.org/";

	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String DOWNLOAD_FILE_PATH = PROJECT_PATH + "\\downloadFiles\\";
}