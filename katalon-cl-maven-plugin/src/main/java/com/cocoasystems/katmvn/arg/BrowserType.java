package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

/**
 * Command specifies a valid Katalon browser type.
 */
public class BrowserType implements Argument {

	enum Types {
		Firefox,
		Chrome,
		IE,
		Safari,
		Remote,
		Android,
		iOS
	};

	public String format(Command command) {
		try {
			final String browserType = command.getBrowserType();

			Types.valueOf(browserType);

			return String.format("-browserType=%s", browserType);

		} catch (Exception e) {

			throw new RuntimeException("Unsupported browser type '%s'");
		}

	}

}
