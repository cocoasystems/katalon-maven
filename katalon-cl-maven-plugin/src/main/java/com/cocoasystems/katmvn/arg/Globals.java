package com.cocoasystems.katmvn.arg;

import java.util.Map;

import com.cocoasystems.katmvn.command.Command;

/**
 * Formats the Katalon command line arguments for optional project
 * global variables.
 */
public class Globals implements Argument {

	public String format(Command command) {
		
		StringBuilder result = new StringBuilder();
		
		Map<String, String> globals = command.getGlobals();
		
		if(globals != null) {
			
			for(String key: globals.keySet()) {
				result.append(String.format("-g_%s=\"%s\" ", key, globals.get(key)));
			}
		}
		
		return result.toString();
	}

}
