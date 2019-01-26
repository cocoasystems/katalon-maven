package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

/**
 * Argument hides the Katalon splash screen while running in Maven.
 */
public class NoSplash implements Argument {
	
	public String format(Command command) {
		return "-noSplash";
	}

}
