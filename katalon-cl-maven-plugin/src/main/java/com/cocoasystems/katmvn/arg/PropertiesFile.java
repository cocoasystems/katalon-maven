package com.cocoasystems.katmvn.arg;

import java.io.File;

import com.cocoasystems.katmvn.command.Command;

public class PropertiesFile implements Argument {

	public String format(Command command) {
		
		String result = "";
		String propertiesFile = command.getPropertiesFile();
		if(propertiesFile != null) {
			
			if(new File(propertiesFile).exists() == false) {
				throw new RuntimeException(String.format("Properties file not found, %s", propertiesFile));
			}
			result = String.format("-propertiesFile=\"%s\"", propertiesFile);
			
		}
		return result;
	}

}
