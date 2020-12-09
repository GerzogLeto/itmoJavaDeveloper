package com.grudnov.lessons.lesson25.hw_top_n_word;

import com.grudnov.lessons.lesson25.IncrementTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        int processors = Runtime.getRuntime().availableProcessors();
        Map<String, Long> map = new HashMap<>();
        ArrayList<CounterWords> counters = new ArrayList<>();
        List<String> lists = Files.readAllLines(Paths.get("sources/task23.txt"));
        int step = lists.size()/processors;
        if(step %2 ==0) step++;

        for (int i = 0, start = 0, end = step; i < processors; i++) {
            counters.add(new CounterWords(map,lists.subList(start, end)));
            start = end;
            end = end + step;
            if(end > lists.size()) end = lists.size();
        }
        for (CounterWords counter : counters) {
            counter.start();
        }
        for (CounterWords counter : counters) {
            try {
                counter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        map.entrySet().stream().sorted((entry1, entry2)-> entry2.getValue().compareTo(entry1.getValue())).
                limit(10).forEach(entry-> System.out.println(entry.getKey() + "(" +
                entry.getValue() + ") "));

    }
}