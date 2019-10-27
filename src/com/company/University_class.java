package com.company;

import java.util.*;

public class University_class {

    public static void main(String[] args){
        Bachelor vasya = new Bachelor("Vasya Pupkin", 2);
        System.out.println(vasya.getGrade());

    }
}

class Teacher {
    private String name;
    private ArrayList<Shedule> TeacherShedule = new ArrayList<>(0);
    protected void getTeacherShedule(String day_name) {
        for (Shedule elem : this.TeacherShedule) {
            if (elem.getDay().equals(day_name)) {
                System.out.println(elem.getLesson());
            }
        }
    }
    protected String getName() {
        return this.name;
    }
}

class Shedule {
    private String day;
    private Map<String, String> lesson = new HashMap<> (7);
    protected void setShedule(String d, Map<String, String> s) {
        this.day = d;
        for (Map.Entry entry : s.entrySet()) {
            this.lesson.put(entry.getKey().toString(), entry.getValue().toString());
        }

    }
    protected Map<String, String> getLesson() {
        return this.lesson;
    }
    protected String getDay() {
        return this.day;
    }
    public void setDay(String d) {
        this.day = d;
    }
}

class Student extends Shedule{
    private String name;
    private Integer kurs;
    private ArrayList<Shedule> StudentShedule = new ArrayList<>(5);
    Student (String n, Integer k) {
        name = n;
        kurs = k;
    }
    protected void getStudentShedule(String day_name) {
        for (Shedule elem : this.StudentShedule) {
            if (day_name.equals("all") || day_name.equals("All")) {
                System.out.println(elem.getLesson());
            } else if (elem.getDay().equals(day_name)) {
                System.out.println(elem.getLesson());
            }
        }
    }
    protected void addStudentShedule() {
        System.out.println("Enter day and day`s lessons");
        Scanner sentense = new Scanner(System.in);
        String day = sentense.nextLine();
        HashMap<String, String> shed = new HashMap<>();
        for (int i=0;i<4;i++) {
            Scanner les = new Scanner(System.in);
            shed.put(les.nextLine().split(" ")[0].toString(), les.nextLine().split(" ")[1]);
        }
//        this.StudentShedule.setShedule(day, shed);

    }
    protected String getName() {
        return this.name;

    }
    protected Integer getKurs(){
        return this.kurs;
    }
}

class Bachelor extends Student {
    private String grade = "Bachelor";
    Bachelor(String n, Integer k) {
        super(n, k);
    }
    protected String getGrade(){
        return this.grade;
    }
}

class MasterStudent extends Student {
    private String grade = "Master Student";
    MasterStudent( String n, Integer k) {
        super(n, k);
    }
    protected String getGrade(){
        return this.grade;
    }
}