package com.grudnov.lessons.lesson15.hwEmployee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Employee> listEmployess = Employee.employeeGenerator(30);
        System.out.println(listEmployess);
        Comparator<Employee> comparatorByName = new NameComparator();
        Comparator<Employee> comparatorByNameBySalary = new NameComparator().thenComparing(new SalaryComparator());
        Comparator<Employee> comparatorByNameBySalaryByAgeByCompany =
                new NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator())
                        .thenComparing(new NameComparator());
        System.out.println("sort by field name:");
        Collections.sort(listEmployess,comparatorByName);
        System.out.println(listEmployess);
        System.out.println("sort by field name, salary:");
        Collections.sort(listEmployess,comparatorByNameBySalary);
        System.out.println(listEmployess);
        System.out.println("sort by field name, salary, age and company:");
        Collections.sort(listEmployess,comparatorByNameBySalaryByAgeByCompany);
        System.out.println(listEmployess);
    }
}
