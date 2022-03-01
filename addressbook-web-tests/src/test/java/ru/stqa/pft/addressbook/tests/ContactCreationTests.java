package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddContact();
    GroupData groupData = new GroupData("test1", null, null);
    chekGroupSelection(groupData);
    app.getContactHelper().createContact(new ContactData("Ilya", "Malyshev",
            "100 WILLIAM STREET, SUITE 210", "admin@admin.test",
            "79999999999", "78888888888",
            "77777777777", "76666666666",
            groupData.getName()), groupData);
  }

  // Метод проверки предусловия: выбор группы на форме создания контакта, а в случае отсутствия группы - ее создание
  private void chekGroupSelection(GroupData groupData) {
    if (! app.getContactHelper().selectedGroupForContact(groupData.getName())) {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().createGroup(groupData);
      app.getNavigationHelper().gotoAddContact();
    }
  }
}
