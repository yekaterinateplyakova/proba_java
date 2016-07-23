package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kompu on 5/29/2016.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(ApplicationManager app) {
    super(app);
  }

  public void returnToGroups() {
    click(By.linkText("group page"));
  }

  public void submitGroup() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
      type(By.name("group_name"), groupData.getName());
      type(By.name("group_header"), groupData.getHeader());
      type(By.name("group_footer"), groupData.getFooter());
  }

  public void createNew() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void subminGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    createNew();
    fillGroupForm(group);
    submitGroup();
    groupCache = null;
    returnToGroups();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache = null;
    returnToGroups();
  }

  public boolean isThereAGroup() {
    return (isElementPresent(By.name("selected[]")));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }


  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    groupCache = null;
    subminGroupModification();

  }


  public void deleteContactFromGroup(GroupData group, ContactData contact) {
    app.goTo().home();
    app.contact().selectFromDropDownList(".//*[@id='right']/select", group.getName());
    app.contact().selectContactById(contact.getId());
    app.contact().click(By.name("remove"));
    app.goTo().home();
  }
}
