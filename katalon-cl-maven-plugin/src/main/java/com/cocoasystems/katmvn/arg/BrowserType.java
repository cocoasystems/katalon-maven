package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

/**
 * Command specifies a valid Katalon browser type.
 */
public class BrowserType implements Argument {
	
	enum Type {
		Firefox("Firefox"),
		Chrome("Chrome"),
		ChromeHeadless("Chrome (headless)"),
		IE("IE"),
		Safari("Safari"),
		Remote("Remote"),
		Android("Android"),
		iOS("iOS");
		
		private String value;
		Type(String value) {
			this.value = value;
		}
		
		static Type findByValue(String value) {
			for(Type type: Type.values()) {
				if(type.value.equals(value)) {
					return type;
				}
			}
			return null;
		}
	};

	public String format(Command command) {

		final String browserType = command.getBrowserType();
		
		if(Type.findByValue(browserType) == null) {
			
			throw new RuntimeException(
					String.format("Unsupported browser type '%s'",
							browserType));
		} else {
			
			return String.format("-browserType=%s", browserType);
		}

	}

}
