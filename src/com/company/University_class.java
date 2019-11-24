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
            Scanner choose = new Scanner(System.in);
            String res = choose.nextLine();
            choose.close();
//            System.out.println("wait");
            switch (res) {
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
    private static void AddNewStudent(ArrayList<Bachelor> Bach, ArrayList<MasterStudent> Mast) {
        System.out.println("Укажите степень студента(Бакалавр, Магистр)");
        Scanner step = new Scanner(System.in);
        String res = step.nextLine();
        if (res.toLowerCase()=="бакалавр") {
            System.out.print("Введите <Имя Фамилия,курс,группа>");
            String[] new_data = (new Scanner(System.in)).nextLine().split(",");
            Bachelor person = new Bachelor(new_data[0].toLowerCase(), Integer.valueOf(new_data[1]), Integer.valueOf(new_data[2]));
            System.out.print("Хотите установить расписание?");
            Scanner ans = new Scanner(System.in);
            if (ans.nextLine().toLowerCase().equals("да")) {
                ans.close();
                person.addStudentShedule();
            }
            Bach.add(person);
            step.close();
        } else if (res=="магистр") {
            System.out.print("Введите <Имя Фамилия,курс,группа>");
            String[] new_data = (new Scanner(System.in)).toString().split(",");
            MasterStudent person = new MasterStudent(new_data[0], Integer.valueOf(new_data[1]), Integer.valueOf(new_data[2]));
            System.out.print("Хотите установить расписание?");
            Scanner ans = new Scanner(System.in);
            if (ans.nextLine().toLowerCase().equals("да")) {
                person.addStudentShedule();
                ans.close();
            }
            Mast.add(person);
            step.close();
        } else {
            System.out.println("Неверная степень");
            step.close();
        }
    }
    private static void AddNewTeacher(ArrayList<Teacher> Teach) {
        System.out.println("Введите имя преподавателя");
        String data = (new Scanner(System.in)).nextLine().toLowerCase();
        Teacher person = new Teacher(data);
        System.out.print("Хотите установить расписание?");
        Scanner res = new Scanner(System.in);
        if (res.toString().toLowerCase().equals("да")) {
            person.addTeacherShedule();
        }
        Teach.add(person);
    }
    private static void ViewStudents(ArrayList<Bachelor> Bach, ArrayList<MasterStudent> Mast) {
        for (Bachelor elem : Bach) {
            System.out.println("wait");
        }

        System.out.println("wait");
    }
    private static void ViewTeachers(ArrayList<Teacher> Teach) {

    }
}


class Teacher extends Shedule{
    private String name;
    private ArrayList<Map<String, ArrayList<Map>>> TeacherShedule = new ArrayList<>(0);
    Teacher(String name) {
        this.name = name;
    }
    protected void getTeacherShedule(String day_name) {
        for (Map.Entry<String, ArrayList<Map<String, String>>> elem : getLesson().entrySet()) {
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
    private Map<String, ArrayList<Map<String, String>>> lesson = new HashMap<String, ArrayList<Map<String, String>>>(4);
    protected Map<String, ArrayList<Map>> setShedule() {
        System.out.println("Введите день, а затем расписание на день в формате <Номер, пара>");
        Scanner res = new Scanner(System.in);
        String day = res.nextLine();
        ArrayList<Map<String, String>> list = new ArrayList<>();
        for (Integer i=0; i<4; i++) {
            Scanner pair = new Scanner(System.in);
            String[] text = pair.nextLine().split(",");
            Map<String, String> k = new HashMap<>();
            k.put(text[0], text[1]);
            list.add(k);
        }
        return (Map<String, ArrayList<Map>>) lesson.put(day, list);
    }
    protected Map<String, ArrayList<Map<String, String>>> getLesson() {
        return this.lesson;
    }

}

class Student extends Shedule{
    private String name;
    private Integer kurs;
    private Integer group;
    private ArrayList<Map<String, ArrayList<Map>>> StudentShedule = new ArrayList<Map<String, ArrayList<Map>>>();
    Student (String n, Integer k, Integer g) {
        name = n;
        kurs = k;
        group = g;
    }
    protected void addStudentShedule() {
        this.StudentShedule.add(setShedule());
    }
    protected void getStudentShedule(String day_name) {
        for (Map.Entry<String, ArrayList<Map<String, String>>> elem : getLesson().entrySet()) {
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

