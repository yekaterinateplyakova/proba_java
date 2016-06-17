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
    if (app.contact().list().size() == 0){
      app.goTo().addNew();
      app.contact().create(new ContactData("Yekaterina", "N", "Teplyakova", "Kate", "automation developer",
              "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com",
              12, 11, "1989", "Test1"));
    }
  }
  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Sofy", "N", "Tepl", "Kate", "automation developer", "Koolspan",
            "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342",
            "yekaterin@gmail.com", 12, 11, "1989", null);
    int index = (before.size() - 1);
    app.contact().modify(contact, index);
    app.goTo().home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
