package com.qa_course.tests;

import com.opencsv.exceptions.CsvException;
import com.qa_course.base.TestUtil;
import com.qa_course.pages.PopUpPage;
import com.qa_course.pages.HomePage;
import com.qa_course.pages.SignInPage;
import com.qa_course.pages.SignUpPage;
import com.qa_course.utils.CsvReader;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;



public class SignUpTest extends TestUtil {


    @DataProvider(name = "signUp-data-csv")
    public static Object[][] dataProviderCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signUp-data.csv");
    }

    @Test(dataProvider = "signUp-data-csv")
    public void executeSignUpTest(String firstName, String lastName, String emailAddress, String phoneNumber,
                                  String password, String birthMonth, String birthDay,
                                  String birthYear, String gender) throws InterruptedException {

        PopUpPage popUpPage = new PopUpPage(driver);
        HomePage homePage = popUpPage.goToHomePage();
        Reporter.log("Successful entry to the home page");

        SignInPage signInPage = homePage.clickSignInButton();
        Reporter.log("Successful entry to the Sign In page");

        SignUpPage signUpPage = signInPage.clickSignUpButton();
        Reporter.log("Successful entry to the Sign In page");

        signUpPage.fillName(firstName, lastName);
        signUpPage.fillEmail(emailAddress);
        signUpPage.fillPhone(phoneNumber);
        signUpPage.fillPass(password);
        signUpPage.fillDateOfBirth(birthMonth, birthDay, birthYear);
        signUpPage.fillGender(gender);
        Thread.sleep(1000);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.getEmailValidationMessage(), "This email address is not available for sign up, try something else");
        softAssert.assertEquals(signUpPage.getPasswordValidationMessage(), "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(signUpPage.getPhoneNumberValidationMessage(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(signUpPage.getBirthDateValidationMessage(), "That doesn’t look right, please re-enter your birthday.");

        softAssert.assertAll();




    }

}
