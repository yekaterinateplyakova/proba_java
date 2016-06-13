package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void ContactCreation2() {
        app.getNavigationHelper().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewContactPage();
        ContactData contact = new ContactData("Alenushka56", "N", "Teplyakovaopo", "Kate", "automation developer",
                "Koolspan", "Bethestda", "301-240-234", "301-3234-234", "234-435-342", "32423-2342", "yekaterin@gmail.com",
                12, 11, "1989", "Test1");
        app.getContactHelper().createContact(contact);

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());

        before.add(contact);
        Comparator<? super ContactData> byId  = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
