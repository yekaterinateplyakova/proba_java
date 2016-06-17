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
      app.contact().create(new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
              .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
              .withTitle("automation developer")
              .withEmail("yekaterin@gmail.com").withDate(12).withMonth(11).withYear("1989"));


    }
  }
  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().list();

    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withFirstName("Yekaterina")
            .withMiddleName("N").withLastName("Teplyakova").withNickname("Kate").withAddress("Koolspan")
            .withCompany("koolspan").withHomecell("301250652").withTitle("automation developer")
            .withEmail("yekaterin@gmail.com").withDate(12).withMonth(11).withYear("1989");
    int index =before.size() - 1;
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
