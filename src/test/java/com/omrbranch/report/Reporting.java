package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateJvmReport(String jsonfile) {
		
			File file = new File("C:\\Users\\vasan\\eclipse-workspace\\OmrBranchGroceryApiAutomation\\target");
			Configuration configuration = new Configuration(file, "OMR Branch Grocery API Automation1");
			configuration.addClassifications("Browser", "Chrome");
			configuration.addClassifications("Browser version", "114");
			configuration.addClassifications("OS", "WIN11");
			configuration.addClassifications("Sprint", "35");
			
		ArrayList<String>jsonfiles = new ArrayList<String>();
		jsonfiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonfiles, configuration);
		builder.generateReports();
		
		
		}
	
	
	}
