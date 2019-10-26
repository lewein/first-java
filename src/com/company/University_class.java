package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class University_class {

}

class Teacher {
    private String name;
    private ArrayList<Shedule> TeacherShedule = new ArrayList<>(0);
    public void getTeacherShedule(String day_name) {
        for (Shedule elem : this.TeacherShedule) {
            if (elem.getDay().equals(day_name)) {
                System.out.println(elem.getLesson());
            }
        }
    }
    public String getName() {
        return this.name;
    }
}

class Shedule {
    private String day;
    private HashMap<String, String> lesson = new HashMap<> (8);
    public HashMap<String, String> getLesson() {
        return this.lesson;
    }
    public String getDay() {
        return this.day;
    }
}

class Student {
    private String name;
    private Integer kurs;
    private ArrayList<Shedule> StudentShedule = new ArrayList<>(0);
    public void getStudentShedule(String day_name) {
        for (Shedule elem : this.StudentShedule) {
            if (day_name.equals("all") || day_name.equals("All")) {
                System.out.println(elem.getLesson());
            } else if (elem.getDay().equals(day_name)) {
                System.out.println(elem.getLesson());
            }
        }
    }
    public String getName() {
        return this.name;
    }
    public Integer getKurs(){
        return this.kurs;
    }
}

class Bakalavr extends Student {
    private String grade = "Bakalavr";
    public String getGrade(){
        return this.grade;
    }
}

class Magistrant extends Student {
    private String grade = "Magistrant";
    public String getGrade(){
        return this.grade;
    }
}