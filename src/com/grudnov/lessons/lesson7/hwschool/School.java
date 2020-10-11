package com.grudnov.lessons.lesson7.hwschool;

public class School {
    private final String nameSchool;
    private Director director;
    private Teacher[] teachers;
    private Student[] students;

    public School(String nameSchool, Director director, Teacher[] teachers, Student[] students) {
        if (nameSchool == null) {
            throw new IllegalArgumentException("nameSchool must not be null!");
        }
        if (director == null) {
            throw new IllegalArgumentException("director must not be null!");
        }
        if(teachers == null){
            throw new IllegalArgumentException("teachers must not be null!");
        }
        if(students == null){
            throw new IllegalArgumentException("students must not be null!");
        }
        this.nameSchool = nameSchool;
        this.director = director;
        this.teachers = teachers;
        this.students = students;
    }
    public void oneDayInSchool() {
        this.director.startEducation();
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.teachers.length; j++) {
                if(this.students[i].getStudySubject().
                        equals(this.teachers[j].getTeachSubject())){
                    this.teachers[j].teach(this.students[i]);
                    break;
                }
            }
        }
        this.director.endEducation();
    }
}