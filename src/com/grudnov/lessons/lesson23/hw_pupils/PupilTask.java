package com.grudnov.lessons.lesson23.hw_pupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        String[] namesMale = {"Boris", "Danila", "Sasha", "Vitya", "Borat"};
        String[] namesFemale = {"Elena", "Nastya", "Sveta", "Irina", "Valentina"};
        int[] years = {2010, 2008, 2012, 2013, 2007, 2006};
        int[] months = {1, 5, 8, 9, 10, 12};
        int[] days = {12, 25, 18, 9, 10, 16};
        List<Pupil> pupilList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pupilList.add(Pupil.getInstance(i, namesMale[(int) (Math.random() * namesMale.length)],
                    Pupil.Gender.MALE, LocalDate.of(years[(int) (Math.random() * years.length)],
                            months[(int) (Math.random() * months.length)],
                            days[(int) (Math.random() * days.length)])));
        }
        for (int i = 5; i < 10; i++) {
            pupilList.add(Pupil.getInstance(i, namesFemale[(int) (Math.random() * namesFemale.length)],
                    Pupil.Gender.FEMALE, LocalDate.of(years[(int) (Math.random() * years.length)],
                            months[(int) (Math.random() * months.length)],
                            days[(int) (Math.random() * days.length)])));
        }
        System.out.println(pupilList);
        //System.out.println(getMapByGender(pupilList));
        //System.out.println(getAverageAge(pupilList));
        //System.out.println(getJuniorPupil(pupilList));
        //System.out.println(getOldPupil(pupilList));
        //System.out.println(selectByBirth(pupilList));
        //printUniqPupils(pupilList);
        //System.out.println(getSortedData(pupilList));
        //printFilteredPupilsByAge(pupilList,12,14);
        //System.out.println(filterByName(pupilList,"Elena"));
        System.out.println(getSumAgeByGender(pupilList));
    }
    // обращение к enum Gender через имя класса - Pupil.Gender

    // Используя Stream API:

    // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
    public static Map<Pupil.Gender, List<Pupil>> getMapByGender(List<Pupil> pupilList) {
        Map<Pupil.Gender, List<Pupil>> listMap = pupilList.stream().
                collect(Collectors.groupingBy(Pupil::getGender));
        return listMap;
    }
    // 2. Найти средний возраст учеников

    public static double getAverageAge (List<Pupil> pupilList){
        double avr = 0;
        List<Long> ages = pupilList.stream().map((pupil -> {
            return ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now());
        })).collect(Collectors.toList());
        for (Long age : ages) {
            avr += age;
        }
        return avr/ages.size();
    }

    // 3. Найти самого младшего ученика
    public static Pupil getJuniorPupil (List<Pupil> pupilList){
        return pupilList.stream().min(Comparator.comparing(Pupil::getBirth)).get();
    }

    // 4. Найти самого старшего ученика
    public static Pupil getOldPupil (List<Pupil> pupilList){
        return pupilList.stream().max(Comparator.comparing(Pupil::getBirth)).get();
    }

    // 5. Собрать учеников в группы по году рождения

    public static Map<Integer, List<Pupil>> selectByBirth(List<Pupil> pupilList){
        return pupilList.stream().collect(Collectors.groupingBy((pupil -> pupil.getBirth().getYear())));
    }

    // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
    public static void printUniqPupils(List<Pupil> pupilList){
        Map<String, List<Pupil>> mapaPupils = pupilList.stream().
                collect(Collectors.groupingBy(pupil -> pupil.getName()));
        for (List<Pupil> pupils : mapaPupils.values()) {
            if(pupils.size() == 1) System.out.println(
                    "Name: " + pupils.get(0).getName() +
                    "  Birth: " + pupils.get(0).getBirth());
        }
    }

    // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

    public static List<Pupil> getSortedData(List<Pupil> pupilList){
        return pupilList.stream().sorted(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).
                thenComparing((pupil1, pupil2)->pupil2.getName().compareTo(pupil1.getName()))).
                collect(Collectors.toList());
    }

    // 8. Вывести в консоль всех учеников в возрасте от N до M лет

    public static void printFilteredPupilsByAge(List<Pupil> pupilList, long from, long to){
        pupilList.stream().filter(pupil -> ChronoUnit.YEARS.between(pupil.getBirth(),LocalDate.now()) >= from &&
                ChronoUnit.YEARS.between(pupil.getBirth(),LocalDate.now()) <= to).forEach(System.out::println);
    }

    // 9. Собрать в список всех учеников с именем=someName

    public static List<Pupil> filterByName(List<Pupil> pupilList, String name){
        return pupilList.stream().filter(pupil -> pupil.getName().equals(name)).collect(Collectors.toList());
    }

    // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

    public static Map<Pupil.Gender, Integer> getSumAgeByGender(List<Pupil> pupilList){
        return pupilList.stream().collect(Collectors.toMap(Pupil::getGender,(pupil ->
                (int)ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now())),Integer::sum));
    }
}
