package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String homecell;
  private final String mobile;
  private final String workphone;
  private final String faxPhone;
  private final String email;
  private final int date;
  private final int month;
  private final String year;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String homecell, String mobile, String workphone, String faxPhone, String email, int date, int month, String year) {
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
}
