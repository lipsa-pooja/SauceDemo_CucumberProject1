package com.org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "./src/test/resources/featuresFiles/ProductFunctionality.feature" }, glue = {
		"com.org.stepDefination", "com.org.appHook" },

		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false

)

public class TestRunner {

}

//features=Features Options helps Cucumber to locate the Feature file in the project folder structure
//glue=path where exactly our stepDefination file and application hook is located
//plugin=Specifies different formatting options for the output reports
//pretty=Prints the Gherkin source with additional colors and stack traces for errors
//dryRun=Cucumber will only checks that every Step mentioned in the Feature File have corresponding code written in Step Definition file or not
