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
    if (app.contact().list().size() == 0){
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
              .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
              .withTitle("automation developer"));
    }
  }


  @Test
  public void testContactDeletion(){
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().delete(index);
    app.goTo().home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size()-1, after.size());

    before.remove(index);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}
