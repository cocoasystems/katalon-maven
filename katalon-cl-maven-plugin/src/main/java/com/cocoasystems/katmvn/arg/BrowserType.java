package com.cocoasystems.katmvn.arg;

import java.util.Arrays;

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

		final String browserType = command.getBrowserType();
		
		try {

			Types.valueOf(browserType);

			return String.format("-browserType=%s", browserType);

		} catch (Exception e) {

			throw new RuntimeException(
					String.format("Unsupported browser type '%s', must be one of %s",
							browserType, Arrays.toString(Types.values())));
		}

	}

}
