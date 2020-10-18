package com.employee.demo.StepDefinition;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.employee.demo.EmployeeSillsApplication;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/skills.feature",
				glue= "com.employee.demo.StepDefinition.SkillStepDef",
				plugin= {"pretty", "json:target/JSONReports/report.json"})
@SpringBootTest
@ContextConfiguration(classes = EmployeeSillsApplication.class)
public class TestRunner {

}
