package com.grudnov.lessons.lesson7.hwschool;

public class Teacher extends Person implements Teach {
    private String teachSubject;
    public Teacher(String name, int age, String teachSubject) {
        super(name, age);
        if(teachSubject == null) {
            throw new IllegalArgumentException("teachSubject must not be null!");
        }
        this.teachSubject = teachSubject;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    @Override
    public void teach(Study student) {
        if(student == null){
            throw new IllegalArgumentException("student must not be null!");
        }
        student.study();
        return;
    }
}
