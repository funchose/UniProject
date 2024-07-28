package org.uniproject.comparator;

import org.uniproject.model.University;

public class UniversityYearComparator implements UniversityComparator {
  @Override
  public int compare(University university1, University university2) {
    return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
  }
}
