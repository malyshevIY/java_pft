package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  // Метод возврата на домашнюю страницу
  public void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  // Метод сохранения созданных изменений контакта
  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  // Метод заполнения формы нового контакта
  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys(contactData.firstName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys(contactData.lastName());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).sendKeys(contactData.adress());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys(contactData.email());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).sendKeys(contactData.telephoneHome());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).sendKeys(contactData.telephoneMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).sendKeys(contactData.telephoneWork());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).sendKeys(contactData.telephoneFax());
  }
}
