package ru.stqa.pft.addressbook.appmanager;

//import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kompu on 5/29/2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToContactPage() {
      click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.getFirstName());
      type(By.name("middlename"),contactData.getMiddleName());
      type(By.name("lastname"),contactData.getLastName());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("title"),contactData.getTitle());
      type(By.name("company"),contactData.getCompany());
      type(By.name("address"),contactData.getAddress());
      type(By.name("home"),contactData.getHomecell());
      type(By.name("mobile"),contactData.getMobile());
      type(By.name("work"),contactData.getWorkphone());
      type(By.name("fax"),contactData.getFaxPhone());
      type(By.name("email"), contactData.getEmail());
      selectFormlist(contactData);
      selectFromDropDownList("//div[@id='content']/form/select[1]", contactData.getDate());
      selectFromDropDownList("//div[@id='content']/form/select[2]", contactData.getMonth());
      type(By.name("byear"),contactData.getYear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification(int index) {
    click(By.xpath(".//*[@id='maintable']/tbody/tr["+ index + 2 +"]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    fillContactForm(contact, true);
    submitContactCreation();
    returnToContactPage();

  }

  public void modify(ContactData contact, int index) {
   initContactModification(index);
    fillContactForm(contact, false);
    submitContactModification();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id,firstName, lastName,  null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
