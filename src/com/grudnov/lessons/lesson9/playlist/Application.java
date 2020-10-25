package com.grudnov.lessons.lesson9.playlist;

import java.util.Arrays;

public class Application {
    /*Песня:
название
продолжительность (в секундах)
Исполнитель:
имя
страна
ПлейЛист (максимум 10):
может хранить только уникальные песни (по equals)
должен иметь возможность отобразить общую продолжительность
Должна быть возможность дублировать плей листы*/

    static String getRandomNameTrack(){
        String[] nameTrack = {"Animals", "Summer Time", "This is Live", "Joker", "Gun", "Lucifer", "Crazy Horse",
                "Big Boss"};
        return nameTrack[(int)(Math.random() * nameTrack.length)];

    }

    static String getRandomNamePerformer(){
        String[] namePerformers = {"Chiko", "Bobina", "Paul Okenfold", "DJ Tiesto", "David Guetta", "DJ Baur",
                "DJ Plex", "DJ Alex"};
        return namePerformers[(int)(Math.random() * namePerformers.length)];

    }

    static String getRandomCountryName(){
        String[] countryName = {"Russia", "USA", "Germany", "Italia", "Polish", "Ukraine"};
        return countryName[(int)(Math.random() * countryName.length)];

    }

    static int getRandomDuration(){
        return 180 + (int)(Math.random() * 300);
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Playlist playlist1 = new Playlist();

        for (int i = 0; i < 7; i++) {
            playlist1.addTrack(new Track(getRandomNameTrack(), getRandomDuration(),
                    new Performer(getRandomNamePerformer(), getRandomCountryName())));
        }
        System.out.println("Duration of Playlist: " + playlist1.getGeneralDuration());
        System.out.println(Arrays.toString(playlist1.getTracks()));
        playlist1.addTrack(new Track("Crazy Frog",300, new Performer("Azuka","Japan")));
        playlist1.addTrack(new Track("Crazy Frog",300, new Performer("Azuka","Japan")));
        System.out.println(Arrays.toString(playlist1.getTracks()));
    }
}
