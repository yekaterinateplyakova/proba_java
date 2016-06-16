package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().home();
    if (! app.contact().isThereAContact()){
      app.goTo().AddNewContact();
      app.contact().createContact(new ContactData("Yekaterina", "N", "Teplyakova", "Kate", "automation developer",
              "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com",
              12, 11, "1989", "Test1"));
    }
  }


  @Test
  public void testContactDeletion(){
    List<ContactData> before = app.contact().getContactList();
    app.contact().selectContact(before.size() -1);
    app.contact().deleteSelectedContact();
    app.goTo().home();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(before.size()-1, after.size());

    before.remove(before.size() - 1);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
