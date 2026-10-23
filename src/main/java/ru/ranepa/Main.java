package ru.ranepa;

public class Main {

    public static void main(String[] args) {
        Student student = Student.create("Иванов Иван");
        student.getGrades().add(4);
        student.getGrades().add(5);
        System.out.println(student.average());
        student.printReport();
        University university = new University();
        long student1 = university.enroll("Дементьев Василий");
        long student2 = university.enroll("Шмарков Даниил");
        university.addGrades(student1, 5);
        university.addGrades(student1, 3);
        university.addGrades(student2, 2);
        university.addGrades(student2, 3);
        university.transferToNextCours(student1);
        university.transferToNextCours(student2);
        university.transferToNextCours(student1);
        university.transferToNextCours(student1);
        university.transferToNextCours(student1);
        long student3 = university.enroll("Гутман Илья");
        university.addGrades(student3, 4);
        university.kickStudent(student3);
        try {
            university.addGrades(student3, 3);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
        try {
            university.transferToNextCours(student3);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
        university.Summary();
        // TODO: создать университет
        // TODO: зачислить 2–3 студентов и поставить оценки
        // TODO: перевести студента со средним баллом больше 2.5
        // TODO: перевести студента со средним баллом 2.5 или меньше
        // TODO: перевести студента с 4 курса
        // TODO: отчислить студента и показать отказ
        // TODO: [вариант N] — выполнить свой кейс, строки начинать с [вариант N]
        // TODO: напечатать сводку — в ней должна быть информация из кейса
    }
}
