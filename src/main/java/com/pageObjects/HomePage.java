package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public static final By FLIGHT_HOTEL_CAR = By.cssSelector(".farefinder-options div[data-bdd='farefinder-option-bundles']");
    public static final By FLY_FROM_FIELD =
            By.cssSelector(".farefinder-package input[data-bdd='farefinder-package-origin-location-input']");
    public static final By FLY_TO_FIELD =
            By.cssSelector(".farefinder-package input[data-bdd='farefinder-package-destination-location-input']");
    public static final By DEPARTING_BUTTON =
            By.id("input1-farefinder-package-date");
    public static final By RETURNING_BUTTON =
            By.id("input2-farefinder-package-date");
    public static final By SUBMIT_BUTTON =
            By.cssSelector("button[data-bdd='farefinder-package-search-button']");
    String dateTemplate = ".calendar > div table tbody td[aria-label='%s']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFlightHotelCarButton() {
        findElementVisibleAndEnabled(FLIGHT_HOTEL_CAR).click();
    }

    public void sendTextToFlyFromField(String textToSend) {
        findElementVisibleAndEnabled(FLY_FROM_FIELD).sendKeys(textToSend);
    }

    public void sendTextToFlyToField(String textToSend) {
        findElementVisibleAndEnabled(FLY_TO_FIELD).sendKeys(textToSend);
    }

    public WebElement findElementVisibleAndEnabled(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void pickDepartingDate(LocalDate departureDate) {
        openDepartingDate();
        clickDateFromTable(departureDate);
    }

    private void openDepartingDate() {
        findElementVisibleAndEnabled(DEPARTING_BUTTON).click();
    }

    public void pickReturningDate(LocalDate returningDate) {
        openReturningDate();
        clickDateFromTable(returningDate);
    }

    private void openReturningDate() {
        findElementVisibleAndEnabled(RETURNING_BUTTON).click();
    }

    private void clickDateFromTable(LocalDate date) {
        findElementVisibleAndEnabled(By.cssSelector(String.format(dateTemplate, date.toString()))).click();
    }

    public void clickSubmitButton() {
        findElementVisibleAndEnabled(SUBMIT_BUTTON).click();
    }
}
