package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
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
    type(By.name("address"), contactData.adress());
    type(By.name("email"), contactData.email());
    type(By.name("home"), contactData.telephoneHome());
    type(By.name("mobile"), contactData.telephoneMobile());
    type(By.name("work"), contactData.telephoneWork());
    type(By.name("fax"), contactData.telephoneFax());

    // Метод проверки на наличие/отсутствие элемента выбора группы на странице создания и модификации контакта
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
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

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
}
