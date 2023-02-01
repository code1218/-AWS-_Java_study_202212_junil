package j19_컬렉션;

import java.util.ArrayList;

import java.util.List;

class Student2 {

    private int studentCode;

    private String studentName;

    public Student2(int studentCode, String studentName) {

        this.studentCode = studentCode;

        this.studentName = studentName;

    }

    public void showStudent() {

        System.out.println("학번: " + studentCode + ", " + "이름: " + studentName);

    }

}

public class Main {

    public static void main(String[] args) {

        List<Student2> students = new ArrayList<>();

        students.add(new Student2(1001, "홍길동"));

        students.add(null);

        students.add(new Student2(1003, "김영희"));

        for (Student2 student : students) {

            if (student == null) {

                student = new Student2(1002, "강철수");

             }

            student.showStudent();

        }
        System.out.println(students);
        

    }

}