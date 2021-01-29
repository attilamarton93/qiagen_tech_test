package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public static final By RESULTS_CONTAINER = By.cssSelector("#resultsContainer article");

  public ResultsPage(WebDriver driver){
    this.driver = driver;
  }

  public List<WebElement> findElementsVisibleAndEnabled(By locator) {
    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  }

  public boolean isResultsEmpty() {
    return !findElementsVisibleAndEnabled(RESULTS_CONTAINER).isEmpty();
  }
}
