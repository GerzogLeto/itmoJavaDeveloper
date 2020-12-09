package com.grudnov.lessons.lesson25.hw_top_n_word;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CounterWords extends Thread {
    private final Map<String, Long> map;
    private final List<String> str;

    public CounterWords(Map<String, Long> map, List<String> str) {
        this.map = map;
        this.str = str;
    }

    @Override
    public void run() {
        Map<String, Long> map1 =str.stream().flatMap(string->Arrays.stream(string.split("[^a-zA-Z]"))).
                filter((string) -> string.length() > 1).
                map((string)->string.toLowerCase()).collect(Collectors.
                toMap(Function.identity(),(string) -> (long)1, (val1, val2)->val1 +val2)).
                entrySet().stream().sorted((entry1, entry2)-> entry2.getValue().compareTo(entry1.getValue())).
                collect(Collectors.toMap((entry)->entry.getKey(),(value)-> value.getValue()));
synchronized (map){
    map1.forEach((key, value)->map.merge(key, value, (v1, v2)-> v1 +v2));

}
    }
}
