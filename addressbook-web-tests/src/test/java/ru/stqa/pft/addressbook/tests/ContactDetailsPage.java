package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kompu on 6/20/2016.
 */
public class ContactDetailsPage extends TestBase {
  @Test
  public void testContactAddress() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
    ContactData contactInfoFromEditPage = app.contact().infoFromEditForm(contact);
    assertThat(cleaned(mergeDetails(contactInfoFromEditPage)), equalTo(contactInfoFromDetailsPage.getAllDetails()));
  }

  private String mergeDetails(ContactData contact) {
    String homePhone = "";
    String mobile = "";
    String work = "";
    if(!contact.getHomePhone().equals("")){
       homePhone = "H: " + contact.getHomePhone();
    }
    if (!contact.getMobile().equals("")){
      mobile = "M: " + contact.getMobile();
    }
    if (!contact.getWorkphone().equals("")){
      work = "W: " + contact.getWorkphone();
    }
    return  Arrays.asList(contact.getFirstName() + " " + contact.getLastName(), contact.getAddress() + "\n", homePhone,
            mobile, work,  "\n" + contact.getEmail()).stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String details){
    return details.replace("  ", " ");

  }
}
