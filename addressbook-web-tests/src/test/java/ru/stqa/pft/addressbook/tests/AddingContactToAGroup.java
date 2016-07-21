package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kompu on 7/20/2016.
 */

public class AddingContactToAGroup extends TestBase {

  @Test
  public void AddingContactToAGroup(){
    GroupData newGroup = app.db().groups().iterator().next();
    ContactData contact = app.db().contacts().iterator().next();
    Groups before = contact.getGroups();
    app.goTo().home();
    app.contact().addGroup(contact, newGroup);
    Groups after = app.db().contactWithACertainID(contact).getGroups();
    assertThat(after, equalTo(before.withAdded(newGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    System.out.println("groups of the contact before" + before);
    System.out.println("groups of the contact after" + after);
    System.out.println("contact name" + contact.getFirstName() +" " + contact.getId() + " " + newGroup.getName());
    System.out.println("Before " + before.size() + "; after  " + after.size());
     //app.contact().verifyContactWasAddedToAGroup(contact, newGroup);



  }





}
