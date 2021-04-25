package com.qa_course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstNameInput;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastNameInput;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailInput;

    @FindBy(id = "reg-error-yid")
    private WebElement emailVal;

    @FindBy(id = "usernamereg-password")
    private WebElement passwordInput;

    @FindBy(id = "reg-error-password")
    private WebElement passwordVal;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "reg-error-phone")
    private WebElement phoneNumberVal;

    @FindBy(id = "usernamereg-month")
    private WebElement monthOfBirthInput;

    @FindBy(id = "usernamereg-day")
    private WebElement dayOfBirthInput;

    @FindBy(id = "usernamereg-year")
    private WebElement yearOfBirthInput;

    @FindBy(id = "usernamereg-freeformGender")
    private WebElement gender;

    @FindBy(id = "reg-error-birthDate")
    private WebElement dateOfBirthVal;

    public SignUpPage  (WebDriver driver) {
        super(driver);
    }

    public String getEmailValidationMessage(){
        return emailVal.getText();
    }

    public String getPasswordValidationMessage(){
        return passwordVal.getText();
    }

    public String getPhoneNumberValidationMessage(){
        return phoneNumberVal.getText();
    }

    public String getBirthDateValidationMessage(){
        return dateOfBirthVal.getText();
    }



    public SignUpPage fillName(String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        return new SignUpPage(driver);
    }

    public SignUpPage fillEmail(String emailAddress){
        emailInput.sendKeys(emailAddress);
        return new SignUpPage(driver);
    }

    public SignUpPage fillPass(String password){
        passwordInput.sendKeys(password);
        return new SignUpPage(driver);
    }

    public SignUpPage fillPhone(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
        return new SignUpPage(driver);
    }

    public SignUpPage fillDateOfBirth(String birthMonth, String birthDay, String birthYear){
        monthOfBirthInput.sendKeys(birthMonth);
        dayOfBirthInput.sendKeys(birthDay);
        yearOfBirthInput.sendKeys(birthYear);
        return new SignUpPage(driver);
    }

    public SignUpPage fillGender(String genderPick){
        gender.sendKeys(genderPick);
        return new SignUpPage(driver);
    }

}
