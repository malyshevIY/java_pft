package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  // Метод возврата на домашнюю страницу
  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  // Метод сохранения созданных изменений контакта
  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  // Метод заполнения формы нового контакта
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.firstName());
    type(By.name("lastname"), contactData.lastName());
    type(By.name("address"), contactData.address());
    type(By.name("email"), contactData.email());
    type(By.name("home"), contactData.telephoneHome());
    type(By.name("mobile"), contactData.telephoneMobile());
    type(By.name("work"), contactData.telephoneWork());
    type(By.name("fax"), contactData.telephoneFax());

    // Условие проверки на наличие/отсутствие элемента выбора группы на странице создания и модификации контакта
    if (creation) {
      selectedGroupForContact(contactData.group());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  // Метод выбора контакта
  public void selectContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  // Метод удаления выбранного контакта/контактов
  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  // Метод скрытия диалогового окна
  public void closeAlert() {
    wd.switchTo().alert().accept();

  }

  // Метод перехода на форму модицификации контакта
  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  // Метод подтверждения изменений при модификации контакта
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  // Метод создания контакта
  public void createContact(ContactData contact) {
    type(By.name("firstname"), contact.firstName());
    type(By.name("lastname"), contact.lastName());
    type(By.name("address"), contact.address());
    type(By.name("email"), contact.email());
    type(By.name("home"), contact.telephoneHome());
    type(By.name("mobile"), contact.telephoneMobile());
    type(By.name("work"), contact.telephoneWork());
    type(By.name("fax"), contact.telephoneFax());
    selectedGroupForContact(contact.group());
    submitContactCreation();
    returnToHomePage();
  }

  // Метод селекта группы для контакта (по тексту) с проверкой исключений
  public boolean selectedGroupForContact(String group) {
    Select newGroup = new Select(wd.findElement(By.name("new_group")));

    try {
      newGroup.selectByVisibleText(group);
      return true;
    }
    catch (NoSuchElementException ex) {
      return false;
    }
  }

  // Метод проверки элементов выбора контакта для удаления и модификации
  public boolean isTheAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"))
            || isElementPresent(By.xpath("//img[@alt='Edit']"));
  }
}
