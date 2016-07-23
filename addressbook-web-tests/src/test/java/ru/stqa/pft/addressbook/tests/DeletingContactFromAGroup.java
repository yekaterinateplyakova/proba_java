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
 * Created by kompu on 7/23/2016.
 */
public class DeletingContactFromAGroup extends TestBase {
  @Test
  public void testDeletingContactFromAGroup(){
    GroupData group = app.db().groups().iterator().next();
    Contacts contacts = group.getContacts();
    if (contacts.size()==0){
      ContactData contact = app.db().contacts().iterator().next();
      app.contact().addGroup(contact, group);
      contacts = app.db().groupsWithACertainId(group).getContacts();
    }
    ContactData contact = contacts.iterator().next();
    Groups before = contact.getGroups();
    Contacts beforeContacts = app.db().groupsWithACertainId(group).getContacts();
    app.group().deleteContactFromGroup(group,contact);
    Groups after = app.db().contactWithACertainID(contact).getGroups();
    Contacts afterContacts = app.db().groupsWithACertainId(group).getContacts();
    assertThat(after, equalTo(before.without(group)));
    assertThat(afterContacts, equalTo(beforeContacts.without(contact)));
    System.out.println("group is " + group.getName());
    System.out.println("before: " + before.size() + "; After : " + after.size());
    System.out.println("beforeContacts: " + beforeContacts.size() + "; AfterContacts : " + afterContacts.size());




  }
}
