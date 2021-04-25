package com.qa_course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    @FindBy(id = "createacc")
    private WebElement createAcc;

    public SignInPage (WebDriver driver) {
        super(driver);
    }

    public com.qa_course.pages.SignUpPage clickSignUpButton(){
        createAcc.click();
        return new com.qa_course.pages.SignUpPage(driver);
    }
}
