package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by kompu on 5/29/2016.
 */
public class NavigationHelper extends HelperBase{

   public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
      click(By.linkText("groups"));
  }
  public void gotoAddNewContactPage() {
    click(By.linkText("add new"));
  }

  public void gotoHome() {
    click(By.linkText("home"));
  }
}
