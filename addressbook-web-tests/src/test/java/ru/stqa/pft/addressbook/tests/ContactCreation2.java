package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation2 extends TestBase {


    @Test
    public void ContactCreation2() {
        app.getContactHelper().gotoAddNew();
        app.getContactHelper().fillContactForm(new ContactData("Yekaterina", "N", "Teplyakova", "Kate", "automation developer", "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com", 12, 11, "1989"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }


}
