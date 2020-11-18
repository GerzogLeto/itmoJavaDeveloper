package com.grudnov.lessons.lesson22.hw3_4;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());

        Predicate<Course> getCoursesLessThreeMonths = (course)->course.getDuration() < 3;
        Predicate<Course> getCoursesWithOptimalPrice = (course)->course.getPrice() < 20_000;
        Predicate<Course> getCoursesByNameJJD = (course)->course.getName().equals("JJD");
        Predicate<Course> getBestCourses = (course)->course.getDuration()<3 && course.getPrice() < 20_000 ;
        Predicate<Course> getBestCourses2 = (course)->(course.getDuration()<3 && course.getPrice() < 20_000) ||
                course.getName().equals("JJD");
        Consumer<Course> incPriceByTen = (course)-> course.setPrice(course.getPrice() + 10_000);

        System.out.println(university.getCourses());
        //System.out.println(university.filtered(getCoursesLessThreeMonths));
        //System.out.println(university.filtered(getCoursesWithOptimalPrice));
        //System.out.println(university.filtered(getCoursesByNameJJD));
        //System.out.println(university.filtered(getBestCourses));
        //System.out.println(university.filtered(getBestCourses2));
        for (Course course : university.getCourses()) {
            incPriceByTen.accept(course);
        }

        System.out.println(university.getCourses());


    }
}
