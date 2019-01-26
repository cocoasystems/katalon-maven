package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

public class RunModeConsoleLog implements Argument {

	public String format(Command command) {
		
		return "-runMode=console -consoleLog";
	}

}
