package com.cocoasystems.katmvn.command;

import java.util.Map;

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
	 * Absolute path to optional properties file.  Properties specified also on the
	 * command line overwrite those in the properties file.
	 */
	String getPropertiesFile();
	
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
	
	/**
	 * Katalon project profile Global variables to be overwritten at the 
	 * command line when running the suite.
	 */
	Map<String, String> getGlobals();

	/**
	 * Optional location of report output files.  Can be absolute path
	 * or relative to Katalon project director.
	 */
	String getReportFolder();
	
	/**
	 * Optional name of report files (.html, .cvs, .log, etc.) when
	 * report folder is provided.
	 */
	String getReportFileName();

}
