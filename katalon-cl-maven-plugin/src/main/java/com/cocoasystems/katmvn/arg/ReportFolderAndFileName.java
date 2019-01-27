package com.cocoasystems.katmvn.arg;

import com.cocoasystems.katmvn.command.Command;

public class ReportFolderAndFileName implements Argument {

	public String format(Command command) {
		
		String reportFolder = command.getReportFolder();
		String reportFileName = command.getReportFileName();
		
		StringBuffer buffer = new StringBuffer();
		
		if(reportFolder != null) {
			
			buffer.append(String.format("-reportFolder=\"%s\"", reportFolder));
			
			if(reportFileName != null) {
				
				buffer.append(String.format("-reportFileName=\"%s\"", reportFileName));
			}
			
		} else {
			if(reportFileName != null) {
				throw new RuntimeException("Report filename cannot be specified without report folder.");
			}
		}
		
		return buffer.toString();
	}

}
