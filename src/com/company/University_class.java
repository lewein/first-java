package com.company;
//диаграммы Закмана
import java.util.*;

public class University_class {

    public static void main(String[] args){
        ArrayList<Bachelor> StudBach = new ArrayList<>();
        ArrayList<MasterStudent> StudMast = new ArrayList<>();
        ArrayList<Teacher> Teach = new ArrayList<>();
        Boolean start = true;
        while (start) {
            System.out.println("Выберите пункт меню:\n 1.Добавить студента/магистра\n 2.Добавить преподавателя\n 3.Посмотреть студентов\n 4.Посмотреть преподавателей\n 5.Выход");
            Scanner choose  =new Scanner(System.in);
            switch (choose.toString()) {
                case ("1"):
                    AddNewStudent(StudBach, StudMast);
                    break;
                case ("2"):
                    AddNewTeacher(Teach);
                    break;
                case ("3"):
                    ViewStudents(StudBach, StudMast);
                    break;
                case ("4"):
                    ViewTeachers(Teach);
                    break;
                case ("5"):
                    start = false;
                    break;
            }
        }
//        Bachelor vasya = new Bachelor("Vasya Pupkin", 2, 21);
//        for (Integer i=0;i<2;i++){
//             vasya.addStudentShedule();
//        }
//        System.out.println("Choose Lessons day or write All");
//        Scanner day = new Scanner(System.in);
//        vasya.getStudentShedule(day.toString());
//        Teacher MaryIvanna = new Teacher("Mary Ivanna");
//        MaryIvanna.addTeacherShedule();
//        MaryIvanna.getTeacherShedule("Saturday");
    }
    private static void AddNewStudent(ArrayList Bach, ArrayList Mast) {
        System.out.println("Укажите степень студента(Бакалавр, Магистр)");
        Scanner step = new Scanner(System.in);
        if (step.toString()=="Бакалавр") {

        } else if (step.toString()=="Магистр") {

        } else {
            System.out.print("Неверная степень");
        }
    }
    private static void AddNewTeacher(ArrayList Teach) {

    }
    private static void ViewStudents(ArrayList Bach, ArrayList Mast) {

    }
    private static void ViewTeachers(ArrayList Teach) {

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

