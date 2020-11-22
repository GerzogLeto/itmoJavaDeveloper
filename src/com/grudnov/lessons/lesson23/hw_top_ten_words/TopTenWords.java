package com.grudnov.lessons.lesson23.hw_top_ten_words;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        // System.out.println(map);

        Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")).
                map((string-> string.split("[^a-zA-Z]"))).
                flatMap((arr)->Arrays.stream(arr)).filter((string) -> string.length() > 1).
                map((string)->string.toLowerCase()).collect(Collectors.
                toMap(Function.identity(),(string) -> (long)1, (val1, val2)->val1 +val2)).
                entrySet().stream().sorted((entry1, entry2)-> entry2.getValue().compareTo(entry1.getValue())).
                limit(10).collect(Collectors.toMap((entry)->entry.getKey(),(value)-> value.getValue()));
        System.out.println(map);
                //forEach(System.out::println);

    }
}




