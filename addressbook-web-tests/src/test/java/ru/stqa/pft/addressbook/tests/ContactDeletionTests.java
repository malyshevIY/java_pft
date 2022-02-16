package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isTheAContact()) {
      app.getNavigationHelper().gotoAddContact();
      app.getContactHelper().createContact(new ContactData("Ilya", "Malyshev",
              "100 WILLIAM STREET, SUITE 210", "admin@admin.test",
              "79999999999", "78888888888",
              "77777777777", "76666666666",
              "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlert();
    app.getContactHelper().returnToHomePage();
  }
}
