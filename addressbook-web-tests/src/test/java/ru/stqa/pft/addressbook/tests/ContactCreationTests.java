package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {



    @Test
    public void ContactCreation2() {
        app.goTo().home();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/komp.jpg");
        ContactData contact = new ContactData().withFirstName("ooooo").withMiddleName("N").withLastName("Teplyakova")
                .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
                .withTitle("automation developer").withEmail("yekaterin@gmail.com").withDate(12).withPhoto(photo.getAbsoluteFile())
                .withMonth(11).withYear("1989").withGroup("Test2");
        app.goTo().addNew();
        app.contact().create(contact);
        assertThat(app.group().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

    }

}
