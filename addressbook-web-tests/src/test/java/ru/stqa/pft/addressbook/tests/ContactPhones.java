package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kompu on 6/19/2016.
 */
public class ContactPhones extends TestBase {

  @Test
  public void testContactPhones(){
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomecell(), contact.getMobile(), contact.getWorkphone())
            .stream().filter((s)-> !s.equals(""))
            .map(ContactPhones::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phones){
    return phones.replaceAll("[-()]","").replaceAll("\\s","");
  }
}
