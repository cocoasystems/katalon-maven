package com.cocoasystems.katmvn.execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.maven.plugin.logging.Log;

import com.cocoasystems.katmvn.command.Command;

/**
 * Executes the Katalon Studio command line.
 */
public class CommandExecutor {

	private final Log log;

	public CommandExecutor(final Log log) {
		this.log = log;
	}

	/**
	 * Format Katalon command as a String and execute it.
	 * 
	 * @see https://alvinalexander.com/java/edu/pj/pj010016
	 */
	public int execute(final Command command) {

		String buffer = null;

		log.info("Launching Katalon...");

		try {

			final String katalonCommand = new CommandFormatter().format(command);

			log.info(katalonCommand);

			Process process = Runtime.getRuntime().exec(katalonCommand);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// read the output from the command
			log.info("Awaiting Katalon response...\n");
			while ((buffer = stdInput.readLine()) != null) {
				System.out.println(buffer);
			}

			// read any errors from the attempted command
			log.info("Katalon standard error of the command (if any):\n");
			while ((buffer = stdError.readLine()) != null) {
				log.warn(buffer);
			}
			return 0;
		} catch (IOException e) {

			log.error("Unable to execute command", e);
			return -1;
		}
	}

}
