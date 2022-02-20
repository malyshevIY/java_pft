package ru.stqa.pft.addressbook.model;

public record ContactData(String firstName, String lastName, String address,
                          String email, String telephoneHome, String telephoneMobile,
                          String telephoneWork, String telephoneFax, String group) {

}