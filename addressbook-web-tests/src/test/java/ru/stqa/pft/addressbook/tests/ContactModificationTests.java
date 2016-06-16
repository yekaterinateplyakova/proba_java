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
public class ContactModificationTests  extends TestBase {
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
  public void testContactModification(){
    List<ContactData> before = app.contact().getContactList();
    System.out.println("before = " + before.size());
    app.contact().initContactModification((before.size() - 1));
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Sofy", "N", "Tepl", "Kate", "automation developer", "Koolspan",
            "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342",
            "yekaterin@gmail.com", 12, 11, "1989", null);
    app.contact().fillContactForm(contact, false);
    app.contact().submitContactModification();
    app.goTo().home();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
