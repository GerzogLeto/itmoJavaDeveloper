package com.grudnov.lessons.lesson15.hwEmployee;

import java.util.Comparator;

public class CompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
