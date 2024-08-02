package org.uniproject;

import org.uniproject.comparator.StudentComparator;
import org.uniproject.comparator.UniversityComparator;
import org.uniproject.enums.StudentComparatorEnum;
import org.uniproject.enums.UniversityComparatorEnum;
import org.uniproject.model.Student;
import org.uniproject.model.University;
import org.uniproject.utils.ExcelConverter;
import org.uniproject.utils.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    ExcelConverter.getExcelConverterInstance().readWorkbook("src/main/resources/universityInfo.xlsx");
    ExcelConverter.getExcelConverterInstance().readSheets(ExcelConverter.getExcelConverterInstance().getWorkbook());

    StudentComparator studentNameComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.STUDENT_NAME);
    StudentComparator studentAvgScoreComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.AVG_SCORE);
    StudentComparator studentCourseNumberComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.COURSE_NUMBER);
    StudentComparator studentUniversityIdComparator = ComparatorChoice.getStudentComparator(StudentComparatorEnum.UNIVERSITY_ID);

    UniversityComparator universityFullNameComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_FULL_NAME);
    UniversityComparator universityIdComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_ID);
    UniversityComparator universityShortNameComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.UNIVERSITY_SHORT_NAME);
    UniversityComparator universityProfileComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.PROFILE);
    UniversityComparator universityYearComparator = ComparatorChoice.getUniversityComparator(UniversityComparatorEnum.FOUNDATION_YEAR);
    //Сериализация и десериализация всей коллекции элементов типа Student и проверка идентичности
    ArrayList<Student> students = new ArrayList<>();
    ExcelConverter.getExcelConverterInstance().readStudentData().stream()
        .sorted(studentAvgScoreComparator)
        .forEach(students::add);
    ArrayList<Student> studentsAfterJson = (ArrayList<Student>) JsonUtil.getGsonUtilInstance()
        .studentCollectionFromJson(JsonUtil.getGsonUtilInstance().studentCollectionToJson(students));
    System.out.println(studentsAfterJson.toString().equals(students.toString()));
    //Сериализация и десериализация каждого отдельного элемента типа Student с промежуточным выводом для проверки корректности операции
    students.stream().map(n -> JsonUtil.getGsonUtilInstance().studentToJson(n))
        .peek(e -> System.out.println("\nJSON: " + e))
        .map(e -> JsonUtil.getGsonUtilInstance().studentFromJson(e))
        .forEach(System.out::println);

    //Сериализация и десериализация всей коллекции элементов типа University и проверка идентичности
    ArrayList<University> universities = new ArrayList<>();
    ExcelConverter.getExcelConverterInstance().readUniversityData().stream()
        .sorted(universityProfileComparator)
        .forEach(universities::add);
    ArrayList<University> universitiesAfterJson = (ArrayList<University>) JsonUtil.getGsonUtilInstance()
        .universityCollectionFromJson(JsonUtil.getGsonUtilInstance().universityCollectionToJson(universities));
    System.out.println(universitiesAfterJson.toString().equals(universities.toString()));
    //Сериализация и десериализация каждого отдельного элемента типа University с промежуточным выводом для проверки корректности операции
    universities.stream().map(n -> JsonUtil.getGsonUtilInstance().universityToJson(n))
        .peek(e -> System.out.println("\nJSON: " + e))
        .map(e -> JsonUtil.getGsonUtilInstance().universityFromJson(e))
        .forEach(System.out::println);
  }
}