package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

/**
 * Interface provides common behavior for all arguments that take the Maven Mojo
 * command and format the Katalon command line.
 */
public interface Argument {

	/**
	 * Format one argument on the Katalon command line, based on one or more
	 * parameters from the Maven Mojo.
	 * 
	 * @param command
	 *            The Maven Mojo command.
	 * @return One or more Katalon command-line arguments.
	 */
	String format(Command command);

}
