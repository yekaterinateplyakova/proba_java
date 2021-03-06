package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

/**
 * Created by kompu on 5/29/2016.
 */
public class HelperBase {

  public static ApplicationManager app;
  protected WebDriver wd;

//  public HelperBase(WebDriver wd) {
//    this.wd = wd;
//  }

  public HelperBase (ApplicationManager app){
    this.app = app;
    this.wd = app.wd;
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, String file) {
    String s = file;
      if (file != null) {
       wd.findElement(locator).sendKeys(file);
    }
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }
  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void selectFormlist(ContactData contactData) {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + contactData.getDate() + "]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option["+ contactData.getDate() + "]")).click();
      }
  }

  public void selectFromDropDownList(String selectLocator, int optionText) {
    new Select(wd.findElement(By.xpath(selectLocator))).selectByIndex(optionText);
  }
  public void selectFromDropDownList(String selectLocator, String optionText) {
    new Select(wd.findElement(By.xpath(selectLocator))).selectByVisibleText(optionText);
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;

    }
    catch (NoSuchElementException ex) {
      return false;
    }
  }
}
