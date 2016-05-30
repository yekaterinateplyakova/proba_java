package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactModificationTests  extends TestBase {
  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHome();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anya", "N", "Teplyakova", "Kate", "automation developer", "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com", 12, 11, "1989"));
    app.getContactHelper().submitContactModification();
  }

}
