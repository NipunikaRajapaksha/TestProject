package com.hrapp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrapp.utilities.BaseClass;

public class ProfilePage extends BaseClass {
	
	@FindBy(id="container_users")
	WebElement userstab;
	
	@FindBy(xpath="//*[@id=\"pageBody\"]/tbody/tr[1]/td[1]/div/span")
	WebElement profilelable;
	
	@FindBy(xpath="//div[@class='name']")
	WebElement userlist;
	
	@FindBy(xpath="//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")
	WebElement firstname;
	
	@FindBy(name="firstName")
	WebElement fname;
	
	@FindBy(name="lastName")
	WebElement lname;
	
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateEmployeeProfilePage() throws InterruptedException {
		
		userstab.click();
		Thread.sleep(2000);
		String actual = profilelable.getText();
		String expected = "List of Users";
		
		if(actual.equals(expected)) {
			System.out.println("User in Employee profile page");
		}
		else {
			System.out.println("Employee profile page not display");
		}
	}
	
	public void validateEmployeeProfileList() throws InterruptedException {
		List<WebElement> userList=driver.findElements(By.className("name"));
		
		List<String> all_elements_text=new ArrayList<String>();

	    for(int i=0; i<userList.size(); i++){

	        //loading text of each element in to array all_elements_text
	        all_elements_text.add(userList.get(i).getText());
  
	        
	    }
	    if(all_elements_text.size()!=0) {
        	String firstusername = all_elements_text.get(0);
        	firstname.click();
        	Thread.sleep(2000);
        	String actualname = lname.getAttribute("value") + ", " + fname.getAttribute("value");
        	System.out.println(actualname);
        	System.out.println(firstusername);
        	Assert.assertEquals(actualname, firstusername);
	    }
           
	}

}
