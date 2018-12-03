package com.sqs.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	WebDriver driver = null;

    //Initializing the page objects.

    @FindBy(css = "#amount")
    private WebElement inputAmount;

    @FindBy(css = "#from")
    private WebElement inValue;
    
    @FindBy(xpath = "//ul[@id='from_scroller']/li[2]")
    private WebElement selectEuro;

    @FindBy(css = "#to")
    private WebElement outValue;
    
    @FindBy(xpath ="//ul[@id='to_scroller']/li[3]")
    private WebElement SelectGBP;

    @FindBy(css = "#ucc_go_btn_svg")
    private WebElement submitButton;

    @FindBy(css = ".uccResultAmount")
    private WebElement resultAmount;
    
    @FindBy(css = ".uccResultUnit")
    private WebElement resultUnit;
    
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement submitBtn;
    
    @FindBy(xpath = "//div[@id='__tealiumGDPRecModal']/div/div/div/div/div/label")
    private WebElement acceptBtn;
    

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    public WebElement getInputAmount() {
        return inputAmount;
    }

    public WebElement getInValue() {
        return inValue;
    }

    public WebElement getOutValue() {
        return outValue;
    }

    public WebElement SelectEuro() {
        return selectEuro;
    }
    
    public WebElement SelectGBP() {
        return SelectGBP;
    }
    
    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getresultAmount() {
        return resultAmount;
    }
    
    public WebElement getresultUnit() {
    	return resultUnit;        
    }
    
    public WebElement clickSubmitButton() {
    	return submitBtn;
        }
    
    public WebElement acceptButton() {
    	return acceptBtn;
        }
}
