package org.uniproject.utils;

import org.junit.Assert;
import org.junit.Test;
import org.uniproject.model.Student;

import java.util.ArrayList;

public class JsonUtilTest {


  @Test
  public void studentToJsonTest() {
    Student student = new Student("Anna", "213", 2, 4.5f);
    System.out.println(JsonUtil.getGsonUtilInstance().studentToJson(student));
  }

  @Test
  public void studentCollectionToJsonTest() {
    Student student1 = new Student("Anna", "213", 2, 4.5f);
    Student student2 = new Student("Michael", "111", 3, 3.5f);
    Student student3 = new Student("Ivan", "999", 4, 5.0f);
    ArrayList<Student> students = new ArrayList<>();
    students.add(student1);
    students.add(student2);
    students.add(student3);
    System.out.println(JsonUtil.getGsonUtilInstance().studentCollectionToJson(students));
  }

  @Test

  public void studentFromJsonTest() {
    String json = """
        {
          "Full name": "Kate",
          "University ID": "213",
          "Course number": 2,
          "Average exam score": 4.5
        }""";
    Student student = JsonUtil.getGsonUtilInstance().studentFromJson(json);
    System.out.println(student);
  }

  @Test
  public void studentCollectionFromJsonTest() {
    String json = """
    [
    {
      "Full name": "Kate",
        "University ID": "213",
        "Course number": 2,
        "Average exam score": 4.5
    },
    {
      "Full name": "Michael",
        "University ID": "111",
        "Course number": 3,
        "Average exam score": 3.5
    },
    {
      "Full name": "Ivan",
        "University ID": "999",
        "Course number": 4,
        "Average exam score": 5.0
    }
]""";
    ArrayList<Student> students = (ArrayList<Student>) JsonUtil.getGsonUtilInstance().studentCollectionFromJson(json);
    System.out.println(students.get(0));
  }
  @Test
  public void studentCollectionToAndFromJsonTest () {
    Student student1 = new Student("Kate", "213", 2, 4.5f);
    Student student2 = new Student("Michael", "111", 3, 3.5f);
    Student student3 = new Student("Ivan", "999", 4, 5.0f);
    ArrayList<Student> students = new ArrayList<>();
    students.add(student1);
    students.add(student2);
    students.add(student3);
    System.out.println(students);
    ArrayList<Student> students1 = (ArrayList<Student>) JsonUtil.getGsonUtilInstance().studentCollectionFromJson(JsonUtil.getGsonUtilInstance().studentCollectionToJson(students));
    Assert.assertEquals(students.toString(), students1.toString());
  }


}

