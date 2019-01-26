package com.cocoasystems.katmvn.arg;

import java.io.File;

import com.cocoasystems.katmvn.command.Command;


public class KatalonPath implements Argument {

	private static final String KATALON_HOME = "KATALON_HOME";

	public String format(Command command) {
		
		String katalonPath = command.getKatalonPath();
		if (katalonPath == null) {
			katalonPath = System.getenv(KATALON_HOME);

			if (katalonPath == null) {
				throw new RuntimeException(String
						.format("Must provide Katalon path parameter or set %s environment variable", KATALON_HOME));
			}

			if (!katalonPath.endsWith(File.pathSeparator)) {
				katalonPath += File.separator;
			}
			katalonPath += "katalon";
		}

		return katalonPath;
	}

}
