package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

public class SuiteOrCollection implements Argument {

	public String format(Command command) {

		final String testSuitePath = command.getTestSuitePath();

		final String testSuiteCollectionPath = command.getTestSuiteCollectionPath();
		
		if (testSuitePath == null && testSuiteCollectionPath == null) {
			throw new RuntimeException(
				"Must provide path to test suite or test suite collection relative to project.");
		}
		
		String result = null;

		if (testSuiteCollectionPath != null) {
			result = String.format("-testSuiteCollectionPath=\"%s\"", testSuiteCollectionPath);
		}

		if (testSuitePath != null) {
			if (testSuiteCollectionPath != null) {
				// TODO: log warning
			} else {
				result = String.format("-testSuitePath=\"%s\"", testSuitePath);
			}
		}
		return result;

	}
}
