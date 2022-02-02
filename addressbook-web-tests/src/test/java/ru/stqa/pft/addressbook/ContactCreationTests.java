package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

// Создан класс ContactCreationTests, содержащий тест для создания нового контакта
public class ContactCreationTests {
  private WebDriver wd;// Переименована переменная, хранящая ссылку на драйвер

  // Превращаем класс BeforeClass в метод BeforeMethod в соответствии с анатацией Selenium IDE
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
    // Выделяем вспомогательный метод авторизации и параметезируем его
    login("admin", "secret");

  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  // Тестовый метод переименован на testContactCreation
  public void testContactCreation() throws Exception {
    // Выделяем вспомогательный метод перехода на страницу создания нового контакта
    gotoAddContact();
    // Выделяем вспомогательный метод заполнения формы нового контакта
    fillContactForm(new ContactData("Ilya", "Malyshev", "100 WILLIAM STREET, SUITE 210", "admin@admin.test", "79999999999", "78888888888", "77777777777", "76666666666"));
    // Выделяем вспомогательный метод сохранения созданных изменений
    submitContactCreation();
    // Выделяем вспомогательный метод возврата на домашнюю страницу
    returnToHomePage();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  // Метод fillContactForm параметезирован.Параметры метода сгрупированы в объект, создан вспомогательный класс "модельный класс" GroupData для их представления
  private void fillContactForm(ContactData contactData) {
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

  private void gotoAddContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  // Превращаем класс AfterClass в метод AfterMethod в соответствии с анатацией Selenium IDE
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
