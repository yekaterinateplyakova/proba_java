package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {



    @Test
    public void ContactCreation2() {
        app.goTo().home();
        Set<ContactData> before = app.contact().all();

        ContactData contact = new ContactData().withFirstName("Yekaterina").withMiddleName("N").withLastName("Teplyakova")
                .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
                .withTitle("automation developer").withEmail("yekaterin@gmail.com").withDate(12)
                .withMonth(11).withYear("1989").withGroup("Test1");
        app.goTo().addNew();
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size() + 1, after.size());

        contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }

}
