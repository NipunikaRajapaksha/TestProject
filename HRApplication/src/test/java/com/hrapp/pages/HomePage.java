package com.hrapp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrapp.utilities.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"enterTTMainContent\"]/table[1]/tbody/tr[1]/td[1]/div/table/tbody/tr/td[1]")
	WebElement logoname;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateHomePage() throws InterruptedException {
		Thread.sleep(2000);
		String actual = logoname.getText();
		String expected = "Enter Time-Track";
		System.out.println(actual);
		if (actual.equals(expected)) {
			System.out.println("User in home page");
		 }
		else {
		    System.out.println("home page not loaded.");
		     }
	}

}
