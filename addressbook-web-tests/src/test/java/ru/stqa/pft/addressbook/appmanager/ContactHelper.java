package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.firstName());
    type(By.name("lastname"), contactData.lastName());
    type(By.name("address"), contactData.adress());
    type(By.name("email"), contactData.email());
    type(By.name("home"), contactData.telephoneHome());
    type(By.name("mobile"), contactData.telephoneMobile() );
    type(By.name("work"), contactData.telephoneWork());
    type(By.name("fax"), contactData.telephoneFax());
  }
}
