package com.qa_course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpPage  extends BasePage{

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement acceptBtn;

    public PopUpPage (WebDriver driver){
        super(driver);
    }

    public com.qa_course.pages.HomePage goToHomePage() {
        acceptBtn.click();
        return new com.qa_course.pages.HomePage(driver);
    }
}
