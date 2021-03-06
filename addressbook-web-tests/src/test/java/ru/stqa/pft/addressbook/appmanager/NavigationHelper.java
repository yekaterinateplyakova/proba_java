package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by kompu on 5/29/2016.
 */
public class NavigationHelper extends HelperBase{

   public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
      click(By.linkText("groups"));
  }

   public void addNew() {
    if (wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && wd.findElement(By.tagName("label")).getText().equals("Group")){
      return;
    }
    click(By.linkText("add new"));
  }

  public void home() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
      click(By.linkText("home"));
  }
}
