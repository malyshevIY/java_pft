package ru.stqa.pft.addressbook.model;

public class ContactData {

  private final String firstName;
  private final String lastName;
  private final String address;
  private final String email;
  private final String telephoneHome;
  private final String telephoneMobile;
  private final String telephoneWork;
  private final String telephoneFax;
  private final String group;

  public ContactData(String firstName, String lastName, String address, String email,
                     String telephoneHome, String telephoneMobile, String telephoneWork,
                     String telephoneFax, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.telephoneHome = telephoneHome;
    this.telephoneMobile = telephoneMobile;
    this.telephoneWork = telephoneWork;
    this.telephoneFax = telephoneFax;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getTelephoneHome() {
    return telephoneHome;
  }

  public String getTelephoneMobile() {
    return telephoneMobile;
  }

  public String getTelephoneWork() {
    return telephoneWork;
  }

  public String getTelephoneFax() {
    return telephoneFax;
  }

  public String getGroup() {
    return group;
  }
}