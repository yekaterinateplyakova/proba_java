package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Yekaterina")
            .withMiddleName("N").withLastName("Teplyakova").withNickname("Kate").withAddress("Koolspan")
            .withCompany("koolspan").withHomecell("301250652").withTitle("automation developer")
            .withEmail("yekaterin@gmail.com").withDate(11).withMonth(11).withYear("1989");
    app.contact().modify(modifiedContact);
    app.goTo().home();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact)
            .withAdded(contact)));
  }



}
