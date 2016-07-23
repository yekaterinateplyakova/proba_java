package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kompu on 7/20/2016.
 */

public class AddingContactToAGroup extends TestBase {

  @Test
  public void AddingContactToAGroup(){
    Groups groups = app.db().groups();
    ContactData contact = app.db().contacts().iterator().next();
    Groups before = contact.getGroups();
    GroupData groupToAdd = null;
    Groups contactGroups = contact.getGroups();
    for (GroupData group: groups){
      groupToAdd = group;
      for (GroupData contactGroup: contactGroups){
        if (groupToAdd.equals(contactGroup)){
          groupToAdd = null;
          break;
        }
      }
      if (groupToAdd!=null){
        app.contact().addGroup(contact, groupToAdd);
        break;
      }
    }
    if (groupToAdd==null){
      LocalDateTime ldt = LocalDateTime.now();
      groupToAdd = new GroupData().withName("NewGroup" + ldt.toString());
      app.group().create(groupToAdd);
      app.contact().addGroup(contact, groupToAdd);
      Groups after = app.db().contactWithACertainID(contact).getGroups();
      groupToAdd = groupToAdd.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    }
    Groups after = app.db().contactWithACertainID(contact).getGroups();
    assertThat(after, equalTo(before.withAdded(groupToAdd)));
  }





}
