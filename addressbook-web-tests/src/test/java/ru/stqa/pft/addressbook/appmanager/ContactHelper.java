package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

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

  public void fillContactForm(ContactData contactData) {
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

  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
}
