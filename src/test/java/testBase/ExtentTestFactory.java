package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {

	// Singleton Design Pattern
	private static ExtentTestFactory instance = new ExtentTestFactory();

	private ExtentTestFactory() {
	}

	public static ExtentTestFactory getInstance() {
		return instance;
	}

	// Factory Design Pattern
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest.set(extentTest);
	}

	public ExtentTest getExtentTest() {
		if (extentTest.get() == null) {
	        throw new IllegalStateException("ExtentTest is not initialized.");
	    }
		return extentTest.get();
	}

	public void removeExtentTest() {
		extentTest.remove();
	}
}
