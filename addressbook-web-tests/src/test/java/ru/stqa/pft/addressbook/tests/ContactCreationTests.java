package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddContact();
    app.getContactHelper().createContact(new ContactData("Ilya", "Malyshev",
            "100 WILLIAM STREET, SUITE 210", "admin@admin.test",
            "79999999999", "78888888888",
            "77777777777", "76666666666",
            "test1"), true);
  }
}
