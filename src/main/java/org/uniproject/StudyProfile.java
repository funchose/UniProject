package org.uniproject;

public enum StudyProfile {
  PHYSICS("Физика"),
  ENGLISH("Английский язык"),
  MATH("Математика"),
  CHEMISTRY("Химия");


  public String getProfileName() {
    return this.profileName;
  }

  private final String profileName;

  StudyProfile(String profileName) {
    this.profileName = profileName;
  }
}
