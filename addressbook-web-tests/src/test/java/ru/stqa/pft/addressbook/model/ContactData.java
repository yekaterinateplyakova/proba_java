package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private  String middleName;
  private final String lastName;
  private  String nickname;
  private  String title;
  private  String company;
  private final String address;
  private final String homecell;
  private  String mobile;
  private  String workphone;
  private  String faxPhone;
  private  String email;
  private  int date;
  private  int month;
  private  String year;
  private String group;

  public ContactData(int id,String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String homecell, String mobile, String workphone, String faxPhone, String email, int date, int month, String year,String group) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homecell = homecell;
    this.mobile = mobile;
    this.workphone = workphone;
    this.faxPhone = faxPhone;
    this.email = email;
    this.date = date;
    this.month = month;
    this.year = year;
    this.group = group;
  }
  public ContactData(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String homecell, String mobile, String workphone, String faxPhone, String email, int date, int month, String year,String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homecell = homecell;
    this.mobile = mobile;
    this.workphone = workphone;
    this.faxPhone = faxPhone;
    this.email = email;
    this.date = date;
    this.month = month;
    this.year = year;
    this.group = group;
  }
  public ContactData(int id, String firstName, String lastName, String address, String homecell) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.homecell = homecell;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
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

  public String getHomecell() {
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
