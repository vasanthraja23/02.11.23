package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.base.BaseClass;
import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
    @CucumberOptions(tags="@login or @state or @city or @address",dryRun =false,publish=true,plugin = {"json:target//report.json"},features="C:\\Users\\vasan\\eclipse-workspace\\OmrBranchGroceryApiAutomation\\src\\test\\resources\\Features",glue= "com.omrbranch.stepdefinition",monochrome=true)
	public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJvmReport("target\\report.json");
			
		}
	
		

	}
