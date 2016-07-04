package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("Contacts")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column (name = "firstname")
  private String firstName;

  private  String middleName;

  @Expose
  @Column (name = "lastname")
  private String lastName;

  private  String nickname;

  private  String title;

  private  String company;

  @Expose
  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column (name = "home")
  @Type(type = "text")
  private String homecell;

  @Expose
  @Column (name = "mobile")
  @Type(type = "text")
  private  String mobile;

  @Transient
  private  String allPhones;

  @Column (name = "work")
  @Type(type = "text")
  private  String workphone;

  @Column (name = "fax")
  @Type(type = "text")
  private  String faxPhone;

  @Column (name = "email")
  @Type(type = "text")
  private  String email;

  @Column (name = "email2")
  @Type(type = "text")
  private  String email2;

  @Column (name = "email3")
  @Type(type = "text")
  private  String email3;



  @XStreamOmitField
  @Column (name = "bmonth")
  @Transient
  private  int month;

  @Column (name = "byear")
  private  String year;

  @Expose
  @Transient
  private String group;

  @Transient
  private String allEmails;
  @Transient
  private String allDetails;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  @XStreamOmitField
  @Column (name = "bday")
  //@Type(type = "tinyint")
  @Transient
  private  short date;

  public File getPhoto() {
    return new File (photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllDetails(String allDetails) {
    this.allDetails = allDetails;
    return this;
  }

  public String getAllDetails() {

    return allDetails;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }


  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

 public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomecell(String homecell) {
    this.homecell = homecell;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withDate(int date) {
    this.date = (short)(date);
    return this;
  }

  public ContactData withMonth(int month) {
    this.month = month;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

   public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id=" + id +
            '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homecell;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getEmail() {
    return email;
  }

  public int getDate() {
    return date;
  }

  public int getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getGroup() {
    return group;
  }
}
