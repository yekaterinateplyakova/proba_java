package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/cont" +
                "acts2.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }
    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/cont" +
                "acts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }
    @Test (dataProvider = "validContactsFromJson")
    public void ContactCreation2(ContactData contact) {
        app.goTo().home();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/komp.jpg");
        //ContactData contact = new ContactData().withFirstName("ooooo").withMiddleName("N").withLastName("Teplyakova")
        //        .withNickname("Kate").withAddress("Koolspan").withCompany("koolspan").withHomecell("301250652")
          //      .withTitle("automation developer").withEmail("yekaterin@gmail.com").withDate(12).withPhoto(photo.getAbsoluteFile())
            //    .withMonth(11).withYear("1989").withGroup("Test2");
        app.goTo().addNew();
        app.contact().create(contact);
        assertThat(app.group().count(), equalTo(before.size()+1));
        Contacts after =  app.db().contacts();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
        verifyContactListInUI();

    }

}
