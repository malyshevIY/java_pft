package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd = wd;
  }

  // Метод возврата на страницу групп после созадния/редактирования группы
  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  // Метод подтверждения создания группы
  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // Метод заполения формы группы
  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).sendKeys(groupData.name());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.header());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.footer());
  }

  // Метод перехода на страницу создания новой группы
  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  // Метод удаления выбранной группы
  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  // Метод выбора группы
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
