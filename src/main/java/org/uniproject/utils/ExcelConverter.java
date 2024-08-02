package org.uniproject.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.uniproject.enums.StudyProfileEnum;
import org.uniproject.model.Student;
import org.uniproject.model.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelConverter {
  private static ExcelConverter converter;
  XSSFSheet studentSheet;
  XSSFSheet universitySheet;

  public XSSFWorkbook getWorkbook() {
    return workbook;
  }

  XSSFWorkbook workbook;

  private ExcelConverter() {
  }

  public static ExcelConverter getExcelConverterInstance() {
    if (converter == null) {
      converter = new ExcelConverter();
    }
    return converter;
  }

  public void readWorkbook(String file) throws IOException {
    this.workbook = new XSSFWorkbook(new FileInputStream(file));
  }

  public void readSheets(XSSFWorkbook workbook) {
    this.studentSheet = workbook.getSheet("Студенты");
    this.universitySheet = workbook.getSheet("Университеты");
  }

  public ArrayList<Student> readStudentData() {
    ArrayList<Student> students = new ArrayList<>();
    Iterator rowIter = studentSheet.rowIterator();
    XSSFRow row = (XSSFRow) rowIter.next();
    while (rowIter.hasNext()) {
      Student student = new Student();
      row = (XSSFRow) rowIter.next();
      student.setUniversityId(row.getCell(0).getStringCellValue());
      student.setFullName(row.getCell(1).getStringCellValue());
      student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
      student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
      students.add(student);
    }
    return students;
  }

  public ArrayList<University> readUniversityData() {
    ArrayList<University> universities = new ArrayList<>();
    Iterator rowIter = universitySheet.rowIterator();
    XSSFRow row = (XSSFRow) rowIter.next();
    while (rowIter.hasNext()) {
      row = (XSSFRow) rowIter.next();
      University university = new University();
      university.setId(row.getCell(0).getStringCellValue());
      university.setFullName(row.getCell(1).getStringCellValue());
      university.setShortName(row.getCell(2).getStringCellValue());
      university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
      university.setMainProfile(StudyProfileEnum.valueOf(row.getCell(4).getStringCellValue()));
      universities.add(university);
    }
    return universities;
  }
}