package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  // Метод перехода на страницу групп по ссылке в меню
  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  // Метод перехода на страницу создания нового контакта по ссылке в меню
  public void gotoAddContact() {
    click(By.linkText("add new"));
  }

  // Метода перехода на домашнюю страницу по ссылке в меню
  public void gotoHomePage() {
    click(By.linkText("home"));
  }
}
