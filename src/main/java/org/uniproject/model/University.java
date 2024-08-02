package org.uniproject.model;

import com.google.gson.annotations.SerializedName;
import org.uniproject.enums.StudyProfileEnum;

public class University {
  @SerializedName("University ID")
  String id;
  @SerializedName("Full name")
  String fullName;
  @SerializedName("Abbreviation")
  String shortName;
  @SerializedName("Year of foundation")
  int yearOfFoundation;
  @SerializedName("Main profile")
  StudyProfileEnum mainProfile;

  public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfileEnum mainProfile) {
    this.id = id;
    this.fullName = fullName;
    this.shortName = shortName;
    this.yearOfFoundation = yearOfFoundation;
    this.mainProfile = mainProfile;
  }

  public University() {
  }

  public University setId(String id) {
    this.id = id;
    return this;
  }

  public University setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public University setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public University setYearOfFoundation(int yearOfFoundation) {
    this.yearOfFoundation = yearOfFoundation;
    return this;
  }

  public University setMainProfile(StudyProfileEnum mainProfile) {
    this.mainProfile = mainProfile;
    return this;
  }


  public String getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getShortName() {
    return shortName;
  }

  public int getYearOfFoundation() {
    return yearOfFoundation;
  }

  public StudyProfileEnum getMainProfile() {
    return mainProfile;
  }

  @Override
  public String toString() {
    return String.format("%nID университета: %s%nНазвание: %s%nАббревиатура: %s%n" +
            "Год основания: %d%nПрофиль: %s",
        getId(), getFullName(), getShortName(),
        getYearOfFoundation(), getMainProfile().getProfileName());
  }
}
