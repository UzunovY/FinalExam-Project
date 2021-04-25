package com.qa_course.tests;

import com.opencsv.exceptions.CsvException;
import com.qa_course.base.TestUtil;
import com.qa_course.pages.PopUpPage;
import com.qa_course.pages.HomePage;
import com.qa_course.pages.MainInfoPage;
import com.qa_course.pages.StatisticsPage;
import com.qa_course.utils.CsvReader;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Statistics extends TestUtil {

    @DataProvider(name = "companies-data-csv")
    public static Object[][] dataProviderCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companies-data.csv");
    }

    @Test(dataProvider = "companies-data-csv")
    public void executeStatsTest(String searchField, String dividendsVal, String priceMrqVal) {
        PopUpPage popUpPage = new PopUpPage(driver);
        HomePage homePage = popUpPage.goToHomePage();
        Reporter.log("Successful entry to the home page");

        MainInfoPage mainInfoPage = homePage.searchCompany(searchField);
        Reporter.log("Successful entry to the main statistics page");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainInfoPage.getDividendsValue(), dividendsVal);

        StatisticsPage statisticsPage = mainInfoPage.viewStats();
        Reporter.log("Successful entry to the statistics page");

        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(statisticsPage.getPriceBookValue(), priceMrqVal);


    }
}
