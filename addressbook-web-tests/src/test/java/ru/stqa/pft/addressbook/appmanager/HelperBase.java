package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  // Метод клика
  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  // Метод заполнения текстового поля
  protected void type(By locator, String text) {
    click(locator);
    // Оптимизация текстовых полей - Предоставление возможности оставлять значения по умолчания (null)
    if (text != null) {
      // Извлекаем значение, хранимое в поле ввода
      String existingText = wd.findElement(locator).getAttribute("value");
      // Оптимизация текстовых полей - Проверка совпадения значений в полях ввода
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
