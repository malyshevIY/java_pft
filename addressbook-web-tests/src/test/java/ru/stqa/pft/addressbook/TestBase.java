package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  private WebDriver wd;

  // Метод инициализации
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  // Метод логирования
  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  // Метод возврата на страницу групп после созадния/редактирования группы
  protected void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  // Метод подтверждения создания группы
  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // Метод заполения формы группы
  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys(groupData.name());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.header());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.footer());
  }

  // Метод перехода на страницу создания новой группы
  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  // Метод перехода на страницу групп
  protected void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  // Метод завершения
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

  // Метод удаления выбранной группы
  protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  // Метод выбора группы
  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  // Метод возврата на домашнюю страницу
  protected void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  // Метод сохранения созданных изменений контакта
  protected void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  // Метод заполнения формы нового контакта
  protected void fillContactForm(ContactData contactData) {
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

  // Метод перехода на страницу создания нового контакта
  protected void gotoAddContact() {
    wd.findElement(By.linkText("add new")).click();
  }
}
