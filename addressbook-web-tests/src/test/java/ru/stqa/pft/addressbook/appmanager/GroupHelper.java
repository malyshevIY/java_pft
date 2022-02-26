package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  // Метод возврата на страницу групп после созадния/редактирования группы
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  // Метод подтверждения создания группы
  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  // Метод заполения формы группы
  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  // Метод перехода на страницу создания новой группы
  public void initGroupCreation() {
    click(By.name("new"));
  }

  // Метод удаления выбранной группы
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  // Метод выбора группы/групп
  public void selectGroup() {
    click(By.name("selected[]"));
  }

  // Метод переход на форму модификации группы
  public void initGroupModification() {
    click(By.name("edit"));
  }

  // Метод сохранения формы после модификации группы
  public void submitGroupModification() {
    click(By.name("update"));
  }

  // Метод создания группы
  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  // Метод проверки элемента выбора группы/групп
  public boolean isTheAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}
