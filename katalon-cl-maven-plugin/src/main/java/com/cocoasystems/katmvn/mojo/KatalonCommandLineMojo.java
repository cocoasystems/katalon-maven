package com.cocoasystems.katmvn.mojo;

import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.cocoasystems.katmvn.command.Command;
import com.cocoasystems.katmvn.execute.CommandExecutor;

/**
 * Mojo allows Maven to execute Katalon from the Command Line.
 */
@Mojo(name = "exec-katalon", defaultPhase = LifecyclePhase.DEPLOY)
public class KatalonCommandLineMojo extends AbstractMojo implements Command {

	/**
	 * Returns 0 if Katalon command was executed.  Does not convey
	 * success or failure status of test cases.
	 */
	@Parameter(readonly = true)
	private int exitCode;

	/**
	 * The maven project.
	 */
	@Parameter(readonly=true, defaultValue="${project}")
	private MavenProject mavenProject;

	/**
	 * Path to the Katalon installation.  Optional if KATALON_HOME
	 * environment variable is set.
	 */
	@Parameter()
	private String katalonPath;

	/**
	 * Path to the Katalon project.
	 */
	@Parameter(required = true)
	private String katalonProjectPath;

	/**
	 * Path to test suite relative to the Katalon project path.
	 * One of testSuitePath or testSuiteCollectionPath is required.
	 */
	@Parameter()
	private String testSuitePath;

	/**
	 * Path to test suite collection relative to the Katalon project path.
	 * One of testSuitePath or testSuiteCollectionPath is required.
	 */
	@Parameter()
	private String testSuiteCollectionPath;

	/**
	 * Optional parameter to specify the browser to run tests in.
	 */
	@Parameter(defaultValue = "Chrome")
	private String browserType;
	
	/**
	 * Optional map of Katalon project profile Global variables that you want to override.
	 */
	@Parameter()
	private Map<String, String> globals;

	/**
	 * Builds and executes the Katalon command.
	 */
	public void execute() throws MojoExecutionException {

		try {

			exitCode = new CommandExecutor(getLog()).execute(this);

		} catch (Throwable t) {

			throw new MojoExecutionException("Unable to execute Katalon", t);
		}

	}
	
	public String getMavenProjectBaseDir() {
		return mavenProject.getBasedir().getAbsolutePath();
	}

	public String getKatalonPath() {
		return katalonPath;
	}

	public String getKatalonProjectPath() {
		return katalonProjectPath;
	}

	public String getBrowserType() {
		return browserType;
	}
	
	public String getTestSuitePath() {
		return testSuitePath;
	}

	public String getTestSuiteCollectionPath() {
		return testSuiteCollectionPath;
	}

	public Map<String, String> getGlobals() {
		return globals;
	}

}