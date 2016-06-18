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
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().home();
    if (app.contact().all().size() == 0){
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
              .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
              .withTitle("automation developer"));
    }
  }


  @Test
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().home();
    Contacts after = app.contact().all();
    Assert.assertEquals(before.size()-1, after.size());
    assertThat(after, equalTo(before.without(deletedContact)));

  }

}
