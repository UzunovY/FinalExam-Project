package com.qa_course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    @FindBy(id = "yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id = "header-desktop-search-button")
    private WebElement searchButton;

    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;

    public HomePage (WebDriver driver){
        super(driver);
    }

    public com.qa_course.pages.MainInfoPage searchCompany(String searchField){
        searchInput.sendKeys(searchField);
        searchButton.click();
        return new com.qa_course.pages.MainInfoPage(driver);
    }



    public SignInPage clickSignInButton(){
        signInBtn.click();
        return new SignInPage(driver);
    }
}
