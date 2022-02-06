package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  // Метод перехода на страницу групп по ссылке в меню
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  // Метод перехода на страницу создания нового контакта по ссылке в меню
  public void gotoAddContact() {
    wd.findElement(By.linkText("add new")).click();
  }
}
