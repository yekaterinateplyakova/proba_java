package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactDeletion extends TestBase {
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHome();
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Yekaterina", "N", "Teplyakova", "Kate", "automation developer",
              "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com",
              12, 11, "1989", "Test1"));
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHome();



  }
}
