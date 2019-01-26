package com.cocoasystems.katmvn.command;

/**
 * Specifies the Katalon command-line parameters that are supported in the Maven
 * Mojo plug-in.
 */
public interface Command {
	
	/**
	 * Maven project base directory.
	 */
	String getMavenProjectBaseDir();
	
	/**
	 * Absolute path of the Katalon installation.
	 */
	String getKatalonPath();

	/**
	 * Path to Katalon project.
	 */
	String getKatalonProjectPath();
	
	/**
	 * Path to test suite relative to Katalon project.
	 */
	String getTestSuitePath();

	/**
	 * Path to test suite collection relative to Katalon project.
	 */
	String getTestSuiteCollectionPath();

	/**
	 * Kind of browser to run tests in.
	 */
	String getBrowserType();

}