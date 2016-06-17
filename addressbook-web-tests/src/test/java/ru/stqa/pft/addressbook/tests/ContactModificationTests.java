package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactModificationTests  extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().home();
    if (app.contact().all().size() == 0){
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
              .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
              .withTitle("automation developer")
              .withEmail("yekaterin@gmail.com").withDate(12).withMonth(11).withYear("1989"));


    }
  }
  @Test
  public void testContactModification(){
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Yekaterina")
            .withMiddleName("N").withLastName("Teplyakova").withNickname("Kate").withAddress("Koolspan")
            .withCompany("koolspan").withHomecell("301250652").withTitle("automation developer")
            .withEmail("yekaterin@gmail.com").withDate(12).withMonth(11).withYear("1989");
    int index =before.size() - 1;
    app.contact().modify(modifiedContact);
    app.goTo().home();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedContact);

    before.add(contact);
    Assert.assertEquals(before, after);
  }



}
