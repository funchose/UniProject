package org.uniproject;

public class Main {
  public static void main(String[] args) {
    System.out.println("Университет:");
    University testUni = new University("574", "Политехнический университет",
        "Политех", 1976, StudyProfile.PHYSICS);
    System.out.println(testUni);
    System.out.println("\nСтудент:");
    Student testStudent = new Student("Иван Иванов", "574", 3, 4.5f);
    System.out.println(testStudent);
  }
}