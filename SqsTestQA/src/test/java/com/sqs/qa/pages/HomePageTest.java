package com.sqs.qa.pages;

import com.sqs.qa.testbase.TestBase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by ShilpiBose on 5/20/18.
 */
public class HomePageTest extends TestBase{

	@Parameters({ "browser", "url" })
    @BeforeMethod
    public void setUp(String browser,String url ) {

        driver = initialization(browser, url);
        
    }

    @Test(dataProvider="getData")
    public void testEuroToPound(String euroval, String value) throws InterruptedException {

        HomePage homePageObj = new HomePage(driver);
        
        homePageObj.acceptButton().click();
        homePageObj.clickSubmitButton().click();
        

        WebElement euroValue = homePageObj.getInputAmount();
        System.out.println( euroValue );
        System.out.println( value );
        euroValue.clear();
        euroValue.sendKeys( value );
        
        homePageObj.getInValue().click();
        homePageObj.SelectEuro().click();
        Thread.sleep(2000);
        
        homePageObj.getOutValue().click();
        homePageObj.SelectGBP().click();
        Thread.sleep(3000);

        homePageObj.getSubmitButton().click();
        String conRate= homePageObj.getresultUnit().getAttribute("data-amount");
        System.out.println("The value of the conversion rate is "  + conRate);
        
        String expectedPoundvalue = convertEuroToPound(value, conRate);

        //WebElement actualResult = homePageObj.getresultAmount();

        Assert.assertEquals(homePageObj.getresultAmount().getText(),expectedPoundvalue);
    }

    @AfterMethod
    public void tearDown() {
    	
        if(driver != null) {
            driver.close();
        }
    }

    @DataProvider
    public Object[][] getData()
    {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[5][2];

        // 1st row
        data[0][0] ="euroVal1";
        data[0][1] = "1";

        // 2nd row
        data[1][0] ="euroVal2";
        data[1][1] = "5";

        // 3rd row
        data[2][0] ="euroVal3";
        data[2][1] = "10";

        // 4th row
        data[3][0] ="euroVal4";
        data[3][1] = "15";

        // 5th row
        data[4][0] ="euroVal5";
        data[4][1] = "20";

        return data;
    }

}