package org.uniproject.enums;

public enum StudyProfileEnum {
  PHYSICS("Физика"),
  MATHEMATICS("Математика"),
  MEDICINE("Медицина"),
  LINGUISTICS("Лингвистика");


  public String getProfileName() {
    return this.profileName;
  }

  private final String profileName;

  StudyProfileEnum(String profileName) {
    this.profileName = profileName;
  }
}
