package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    GroupData groupData = new GroupData("test1", null, null);
    if (! app.getContactHelper().isTheAContact()) {
      app.getNavigationHelper().gotoAddContact();
      if (! app.getContactHelper().selectedGroupForContact(groupData.getName())) {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(groupData);
        app.getNavigationHelper().gotoAddContact();
      }
      app.getContactHelper().createContact(new ContactData("Ilya", "Malyshev",
              "100 WILLIAM STREET, SUITE 210", "admin@admin.test",
              "79999999999", "78888888888",
              "77777777777", "76666666666",
              groupData.getName()), groupData);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Test1", "Test2",
            "Test3", "Test@Test.test",
            "Test4", "Test5",
            "Test6", "Test7", groupData.getName()), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
