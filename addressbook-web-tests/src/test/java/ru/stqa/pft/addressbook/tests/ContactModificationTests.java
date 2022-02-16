package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isTheAContact()) {
      app.getNavigationHelper().gotoAddContact();
      app.getContactHelper().createContact(new ContactData("Ilya", "Malyshev",
              "100 WILLIAM STREET, SUITE 210", "admin@admin.test",
              "79999999999", "78888888888",
              "77777777777", "76666666666",
              "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Test1", "Test2",
            "Test3", "Test@Test.test",
            "Test4", "Test5",
            "Test6", "Test7",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
