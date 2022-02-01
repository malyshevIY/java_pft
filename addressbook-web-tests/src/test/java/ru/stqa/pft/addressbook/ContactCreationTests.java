package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

// Создан класс ContactCreationTests, содержащий тест для создания нового контакта
public class ContactCreationTests {
  private WebDriver wd;// Переименована переменная, хранящая ссылку на драйвер

  //Превращаем класс BeforeClass в метод BeforeMethod в соответствии с анатацией Selenium IDE
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
    login();// Выделяем вспомогательный метод авторизации

  }

  private void login() {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception { // Тестовый метод переименован на testContactCreation
    gotoAddContact();// Выделяем вспомогательный метод перехода на страницу создания нового контакта
    fillContactForm();// Выделяем вспомогательный метод заполнения формы нового контакта
    submitContactCreation();// Сохраняем созданный контакт
    returnToHomePage();// Возвращаемся на домашнюю страницу
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys("Ilya");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys("Malyshev");
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).sendKeys("100 WILLIAM STREET, SUITE 210");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).sendKeys("admin@admin.test");
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).sendKeys("79999999999");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).sendKeys("78888888888");
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).sendKeys("77777777777");
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).sendKeys("76666666666");
  }

  private void gotoAddContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  //Превращаем класс AfterClass в метод AfterMethod в соответствии с анатацией Selenium IDE
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
