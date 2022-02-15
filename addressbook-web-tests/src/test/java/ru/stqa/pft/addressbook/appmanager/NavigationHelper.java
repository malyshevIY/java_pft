package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  // Метод перехода на страницу групп по ссылке в меню
  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  // Метод перехода на страницу создания нового контакта по ссылке в меню
  public void gotoAddContact() {
    if (isElementPresent(By.name("theform"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  // Метода перехода на домашнюю страницу по ссылке в меню
  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
