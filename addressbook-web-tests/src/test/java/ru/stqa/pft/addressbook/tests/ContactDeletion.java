package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by kompu on 5/30/2016.
 */
public class ContactDeletion extends TestBase {
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHome();



  }
}
