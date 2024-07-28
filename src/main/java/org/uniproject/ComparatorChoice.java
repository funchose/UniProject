package org.uniproject;

import org.uniproject.comparator.*;
import org.uniproject.enums.StudentComparatorEnum;
import org.uniproject.enums.UniversityComparatorEnum;

public class ComparatorChoice {
  public static StudentComparator getStudentComparator(StudentComparatorEnum studentComparatorEnum) {
    return switch (studentComparatorEnum) {
      case STUDENT_NAME -> new StudentNameComparator();
      case UNIVERSITY_ID -> new StudentUniversityIdComparator();
      case COURSE_NUMBER -> new StudentCourseNumberComparator();
      case AVG_SCORE -> new StudentAvgScoreComparator();
    };
  }

  public static UniversityComparator getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {
    return switch (universityComparatorEnum) {
      case UNIVERSITY_ID -> new UniversityIdComparator();
      case UNIVERSITY_FULL_NAME -> new UniversityFullNameComparator();
      case UNIVERSITY_SHORT_NAME -> new UniversityShortNameComparator();
      case PROFILE -> new UniversityProfileComparator();
      case FOUNDATION_YEAR -> new UniversityYearComparator();
    };
  }
}
