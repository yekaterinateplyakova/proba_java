package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {



    @Test
    public void ContactCreation2() {
        app.goTo().home();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
                .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
                .withTitle("automation developer").withEmail("yekaterin@gmail.com").withDate(12)
                .withMonth(11).withYear("1989").withGroup("Test1");
        app.goTo().addNew();
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size() + 1, after.size());

        before.add(contact);
        Comparator<? super ContactData> byId  = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
