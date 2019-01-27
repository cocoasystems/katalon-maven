package com.cocoasystems.katmvn.execute;

import com.cocoasystems.katmvn.arg.*;
import com.cocoasystems.katmvn.command.Command;

/**
 * Converts a Command into an executable command-line String.
 */
public class CommandFormatter {

	/**
	 * Ordered array of Katalon command arguments.
	 */
	private static final Argument[] ARGUMENTS = { new KatalonPath(), new RunModeConsoleLog(), new ProjectPath(),
			new SuiteOrCollection(), new BrowserType(), new NoSplash(), new ReportFolderAndFileName(), new Globals() };

	public String format(Command command) {
		
		final StringBuffer buffer = new StringBuffer();
		
		for (Argument arg : ARGUMENTS) {

			buffer.append(arg.format(command));
			buffer.append(' ');
		}

		return buffer.toString();
	}
}
