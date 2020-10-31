package com.grudnov.lessons.lesson15.hwEmployee;// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    public Employee(String name, String company, int salary, int age) {
        this.setName(name);
        this.setCompany(company);
        this.setSalary(salary);
        this.setAge(age);
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public void setCompany(String company) {
        this.company = Objects.requireNonNull(company, "company must not be null");
    }

    public void setSalary(int salary) {
        if(salary < 0){
            throw new IllegalArgumentException("salary must not be less then 0");
        }
        this.salary = salary;
    }

    public void setAge(int age) {
        if(age < 21){
            throw new IllegalArgumentException("age must not be less then 21");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int)(Math.random() * names.length)],
                    companies[(int)(Math.random() * companies.length)], (int)(Math.random() * 4),
                    (int)(21 + Math.random() * 39) ));
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }
}