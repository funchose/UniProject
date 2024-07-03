package org.uniproject;

import org.junit.Test;

public class toStringTest {
  @Test
  public void toStringTestUni() {
    University testUni = new University("574", "Политехнический университет",
        "Политех", 1976, StudyProfile.PHYSICS);
    System.out.println(testUni);
  }
  @Test
  public void toStringTestStudent() {
    Student testStudent = new Student("Иван Иванов", "574", 3, 4.5f);
    System.out.println(testStudent);
  }
}
