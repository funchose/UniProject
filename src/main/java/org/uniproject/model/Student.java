package org.uniproject.model;

import com.google.gson.annotations.SerializedName;

public class Student {
  @SerializedName("Full name")
  String fullName;
  @SerializedName("University ID")
  String universityId;
  @SerializedName("Course number")
  int currentCourseNumber;
  @SerializedName("Average exam score")
  float avgExamScore;
  public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
    this.fullName = fullName;
    this.universityId = universityId;
    this.currentCourseNumber = currentCourseNumber;
    this.avgExamScore = avgExamScore;
  }
  public Student(){}
  public Student setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public Student setUniversityId(String universityId) {
    this.universityId = universityId;
    return this;
  }

  public Student setCurrentCourseNumber(int currentCourseNumber) {
    this.currentCourseNumber = currentCourseNumber;
    return this;
  }

  public Student setAvgExamScore(float avgExamScore) {
    this.avgExamScore = avgExamScore;
    return this;
  }

  public String getFullName() {
    return fullName;
  }

  public String getUniversityId() {
    return universityId;
  }

  public int getCurrentCourseNumber() {
    return currentCourseNumber;
  }

  public float getAvgExamScore() {
    return avgExamScore;
  }

  @Override
  public String toString() {
    return String.format("%nИмя: %s%nID университета: %s%nНомер курса: %d%n" +
            "Средний балл: %.2f",
        getFullName(), getUniversityId(),
        getCurrentCourseNumber(), getAvgExamScore());
  }
}
