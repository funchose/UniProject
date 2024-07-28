package org.uniproject;

import org.uniproject.comparator.StudentComparator;
import org.uniproject.comparator.UniversityComparator;
import org.uniproject.enums.StudentComparatorEnum;
import org.uniproject.enums.UniversityComparatorEnum;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    ExcelConverter.getInstance().readWorkbook("src/main/resources/universityInfo.xlsx");
    ExcelConverter.getInstance().readSheets(ExcelConverter.getInstance().workbook);

    StudentComparator studentNameComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.STUDENT_NAME);
    StudentComparator studentAvgScoreComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.AVG_SCORE);
    StudentComparator studentCourseNumberComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.COURSE_NUMBER);
    StudentComparator studentUniversityIdComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.UNIVERSITY_ID);

    UniversityComparator universityFullNameComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_FULL_NAME);
    UniversityComparator universityIdComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_ID);
    UniversityComparator universityShortNameComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_SHORT_NAME);
    UniversityComparator universityProfileComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.PROFILE);
    UniversityComparator universityYearComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.FOUNDATION_YEAR);

    ExcelConverter.getInstance().readStudentData().stream()
        .sorted(studentAvgScoreComparator)
        .forEach(System.out::println);
    ExcelConverter.getInstance().readUniversityData().stream()
        .sorted(universityProfileComparator)
        .forEach(System.out::println);
  }
}