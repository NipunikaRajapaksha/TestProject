package com.hrapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrapp.utilities.BaseClass;

public class AttendencePage extends BaseClass {
	@FindBy(id="container_reports")
	WebElement reportstab;
	
	@FindBy(xpath="//*[@id=\"ext-comp-1017\"]/span")
	WebElement newreport;
	
	@FindBy(xpath="//*[@id=\"createReportLightBox_content\"]/div[2]/div[1]/div/div[1]/div/div[1]/div[4]")
	WebElement leavetimeandbalance;
	
	@FindBy(xpath="//*[@id=\"createReportLightBox_content\"]/div[2]/div[1]/div/div[2]/div/div[4]")
	WebElement configbtn;
	
	@FindBy(xpath="//*[@id=\"applyReportConfiguration\"]/span")
	WebElement generatebtn;
	
	@FindBy(xpath="//tr[@class=\"reportHeaderFooterTr noprint\"]/td[@class=\"headerFooterCell clickableCell export cellWithBorder\"]/div/div")
	WebElement exportreportbtn;
	
	@FindBy(xpath="//*[@id=\"leaveTimeAndBalancesPdfPreviewLightbox_downloadPdfBtn\"]/div")
	WebElement downloadpdf;
	
	
	
	
	public AttendencePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void generateAttendenceReport() throws InterruptedException {
		reportstab.click();
		newreport.click();
		leavetimeandbalance.click();
		configbtn.click();
		generatebtn.click();
		Thread.sleep(2000);
		exportreportbtn.click();
		Thread.sleep(2000);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		//exporttopdf.click();
		Thread.sleep(2000);
	}
	
}
