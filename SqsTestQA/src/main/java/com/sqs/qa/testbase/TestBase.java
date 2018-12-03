package com.sqs.qa.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import java.util.Properties;
//import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static WebDriver initialization(String browser, String url) {

        if (browser.equals( "Chrome" )) {
            System.setProperty( "webdriver.chrome.driver", "src/main/resource/driver/chromedriver.exe" );
            driver = new ChromeDriver();

        } else if (browser.equals( "Firefox" )) {
            System.setProperty( "webdriver.gecko.driver", "src/main/resource/driver/geckodriver.exe" );
            driver = new FirefoxDriver();
        }

        driver.get( url );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        return driver;

    }

    public String convertEuroToPound(String input,String conRate){

        //Declare variables
        Double euro,pounds,conversionrate;
        String output = null;

        //input saying for conversion
        System.out.print("Amount of euro to convert to pound: "+ input);
        euro = Double.parseDouble(input);
       
        conversionrate= Double.parseDouble(conRate);
        
        //checks that inputted euro is not 0
        if(euro !=0){

            pounds = euro * conversionrate;
            System.out.print("The amount in Euro was "+ euro +" and in GBP it is: " + pounds);
            output = String.valueOf(pounds);
        }
        return output;
    }
}
