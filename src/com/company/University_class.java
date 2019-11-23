package com.company;
//диаграммы Закмана
import java.lang.reflect.Array;
import java.util.*;

public class University_class {

    public static void main(String[] args){
        Bachelor vasya = new Bachelor("Vasya Pupkin", 2, 21);
//        System.out.println(vasya.getGrade());
        for (Integer i=0;i<2;i++){
             vasya.addStudentShedule();
        }
        System.out.println("Choose Lessons day or write All");
        Scanner day = new Scanner(System.in);
        vasya.getStudentShedule(day.toString());
        Teacher MaryIvanna = new Teacher("Mary Ivanna");
        MaryIvanna.addTeacherShedule();
        MaryIvanna.getTeacherShedule("Saturday");
    }
}

class Teacher extends Shedule{
    private String name;
    private ArrayList<Map> TeacherShedule = new ArrayList<>(0);
    Teacher(String name) {
        this.name = name;
    }
    protected void getTeacherShedule(String day_name) {
        for (Map.Entry elem : getLesson().entrySet()) {
            if (day_name.equals("all") || day_name.equals("All")) {
                System.out.println(elem.getValue());
            } else if (elem.getKey().equals(day_name)){
                System.out.println(elem.getValue());
            }
        }
    }
    protected String getName() {
        return this.name;
    }
    protected void addTeacherShedule() {
        this.TeacherShedule.add(setShedule());
    }
}

class Shedule {
    private Map<String, ArrayList<Map>> lesson = new HashMap<>(4);
    protected Map<String, ArrayList<Map>> setShedule() {
        System.out.println("Введите день, а затем расписание на день в формате <Номер, пара>");
        Scanner res = new Scanner(System.in);
        String day = res.nextLine();
        ArrayList<Map> list = new ArrayList<>();
        for (Integer i=0; i<4; i++) {
            Scanner pair = new Scanner(System.in);
            String[] text = pair.nextLine().split(",");
            Map<String, String> k = new HashMap<>();
            k.put(text[0], text[1]);
            list.add(k);
        }
        return (Map<String, ArrayList<Map>>) lesson.put(day, list);
    }
    protected Map<String, ArrayList<Map>> getLesson() {
        return this.lesson;
    }

}

class Student extends Shedule{
    private String name;
    private Integer kurs;
    private Integer group;
    private ArrayList<Map> StudentShedule = new ArrayList<>();
    Student (String n, Integer k, Integer g) {
        name = n;
        kurs = k;
        group = g;
    }
    protected void addStudentShedule() {
        this.StudentShedule.add(setShedule());
    }
    protected void getStudentShedule(String day_name) {
        for (Map.Entry elem : getLesson().entrySet()) {
            if (day_name.equals("all") || day_name.equals("All")) {
                    System.out.println(elem.getValue());
                }
            else if (elem.getKey().equals(day_name)) {
                    System.out.println(elem.getValue());
                }
        }
//            System.out.println(day_name);
//            for (Map.entry(String, HashMap) el :elem.get(1)){
//                if (day_name.equals("all") || day_name.equals("All")) {
//                    System.out.println(elem.get(1));
//                } else if (elem.getDay().equals(day_name)) {
//                    System.out.println(elem.getLesson());
//                }
//            }
        }
    protected String getName() {
        return this.name;
    }
    protected Integer getKurs(){
        return this.kurs;
    }
    protected Integer getGroup() {
        return this.group;
    }
}

class Bachelor extends Student {
    private String grade = "Bachelor";
    Bachelor(String n, Integer k, Integer g) {
        super(n, k, g);
    }
    protected String getGrade(){
        return this.grade;
    }
}

class MasterStudent extends Student {
    private String grade = "Master Student";
    MasterStudent( String n, Integer k, Integer g) {
        super(n, k, g);
    }
    protected String getGrade(){
        return this.grade;
    }
}