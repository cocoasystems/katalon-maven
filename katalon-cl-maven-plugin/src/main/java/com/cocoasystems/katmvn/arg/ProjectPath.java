package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

public class ProjectPath implements Argument{

	public String format(Command command) {
		
		String projectPath = command.getKatalonProjectPath();

		// if the user did not provive path to Katalon project
		if(projectPath == null) {
			
			// assume the current Maven project base directory
			projectPath = command.getMavenProjectBaseDir();
		}
		
		return String.format("-projectPath=\"%s\"", projectPath);
	}

	
}
