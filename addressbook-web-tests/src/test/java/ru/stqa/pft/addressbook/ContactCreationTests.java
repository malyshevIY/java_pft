package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoAddContact();
    fillContactForm(new ContactData("Ilya", "Malyshev", "100 WILLIAM STREET, SUITE 210", "admin@admin.test", "79999999999", "78888888888", "77777777777", "76666666666"));
    submitContactCreation();
    returnToHomePage();
  }

}
