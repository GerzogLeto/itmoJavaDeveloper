package com.grudnov.lessons.lesson7.hwschool;

public class Student extends Person implements Study{
    private String studySubject;
    private int iqLevel;

    public Student(String name, int age, String studySubject, int iqLevel){
        super(name, age);
        if(studySubject == null){
            throw new IllegalArgumentException("studySubject must not be null!");
        }
        if(iqLevel <= 0){
            throw new IllegalArgumentException("iqLevel must be more than 0");
        }
        this.studySubject = studySubject;
        this.iqLevel = iqLevel;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public int getIqLevel() {
        return iqLevel;
    }

    @Override
    public void study() {
        this.iqLevel += 5;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", age=" + age + '\'' +
                "studySubject='" + studySubject + '\'' +
                ", iqLevel=" + iqLevel +
                '}';
    }
}
