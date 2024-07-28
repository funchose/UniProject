package org.uniproject.comparator;

import org.uniproject.model.Student;

public class StudentCourseNumberComparator implements StudentComparator {
  @Override
  public int compare(Student student1, Student student2) {
    return Integer.compare(student1.getCurrentCourseNumber(), student2.getCurrentCourseNumber());
  }
}