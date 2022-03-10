package com.google;

import org.testng.TestNG;

import com.google.testcases.GoogleTest;

public class TestRunnerForZenFulcrum {

	static TestNG testNg;
	
	
	public static void main(String args[]) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {GoogleTest.class});
		testNg.run();
	}
}
