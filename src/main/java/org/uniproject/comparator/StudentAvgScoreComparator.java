package org.uniproject.comparator;

import org.uniproject.model.Student;

public class StudentAvgScoreComparator implements StudentComparator {
  @Override
  public int compare(Student student1, Student student2) {
    return Float.compare(student2.getAvgExamScore(), student1.getAvgExamScore());
  }
}
