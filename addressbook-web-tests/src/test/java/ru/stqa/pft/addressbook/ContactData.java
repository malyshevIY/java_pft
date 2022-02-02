package ru.stqa.pft.addressbook;

public record ContactData(String firstName, String lastName, String adress, String email, String telephoneHome, String telephoneMobile,
                          String telephoneWork, String telephoneFax) {
}