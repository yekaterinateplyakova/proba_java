package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kompu on 5/29/2016.
 */
public class HelperBase {

  protected FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  protected void click(By locator) {
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
}
