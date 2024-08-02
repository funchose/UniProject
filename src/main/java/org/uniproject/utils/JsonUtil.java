package org.uniproject.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.uniproject.model.Student;
import org.uniproject.model.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JsonUtil {
  private JsonUtil() {}
  private static JsonUtil jsonUtil;
  Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public static JsonUtil getGsonUtilInstance() {
    if (jsonUtil == null) {
      jsonUtil = new JsonUtil();
    }
    return jsonUtil;
  }

  public String studentToJson(Student student) {
    return gson.toJson(student);
  }
  public String studentCollectionToJson(Collection<Student> collection) {
    return gson.toJson(collection);
  }

  public String universityToJson(University university) {
    return gson.toJson(university);
  }
  public String universityCollectionToJson(Collection<University> collection) {
    return gson.toJson(collection);
  }
  public Student studentFromJson(String string) {
    return gson.fromJson(string, Student.class);
  }
  public Collection<Student> studentCollectionFromJson(String string) {
    Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
    return gson.fromJson(string, listType);
  }
  public University universityFromJson(String string) {
    return gson.fromJson(string, University.class);
  }
  public Collection<University> universityCollectionFromJson(String string) {
    Type listType = new TypeToken<ArrayList<University>>() {}.getType();
    return gson.fromJson(string, listType);
  }
}
