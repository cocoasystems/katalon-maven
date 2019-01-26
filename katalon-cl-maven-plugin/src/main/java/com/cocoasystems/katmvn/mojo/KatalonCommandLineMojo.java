package com.cocoasystems.katmvn.mojo;

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

	@Parameter(readonly = true)
	private int exitCode;

	/**
	 * The maven project.
	 */
	@Parameter(readonly=true, defaultValue="${project}")
	private MavenProject mavenProject;

	@Parameter()
	private String katalonPath;

	@Parameter(required = true)
	private String katalonProjectPath;

	@Parameter()
	private String testSuitePath;

	@Parameter()
	private String testSuiteCollectionPath;

	@Parameter(defaultValue = "Chrome")
	private String browserType;

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

}