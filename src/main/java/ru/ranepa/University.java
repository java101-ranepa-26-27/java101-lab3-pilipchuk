package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    public long enroll(String name) {
        Student student = Student.create(name);
        students.add(student);
        return student.getStudentID();
    }

    private Student findStudentByID(long id){
        for (Student student: students){
            if (student.getStudentID() == id){
                return student;
            }
        }
        throw new IllegalArgumentException("Студент с билетом " + id + " не найден");
    }

    public void addGrades(long id, int grade){
        if (grade <2 || grade >5){
            throw new IllegalArgumentException("Оценка от 2 до 5");
        }
        Student student = findStudentByID(id);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен");
        }
        student.getGrades().add(grade);
    }

    public void kickStudent(long id) {
        Student student = findStudentByID(id);
        if (student == null) {
            throw new RuntimeException("Студент не найден");
        }
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен");
        }
        student.setState(State.DISMISSED);
    }
    public void transferToNextCours(long studentId){
        Student student = findStudentByID(studentId);
        if (student.getState()!= State.ACTIVE){
            throw new IllegalArgumentException("Студент уже отчислен");
        }
        if (student.average()<= 2.5){
            System.out.println("Студент " + student.getName() + " отчислен");
            student.setState(State.DISMISSED);
            return;
        }
        if (student.getCourse() == 4) {
            student.setState(State.GRADUATED);
            return;
        }

        student.setCourse(student.getCourse() + 1);
    }

    public void Summary(){
        for (Student student: students){
            student.printReport();
        }
    }
}



