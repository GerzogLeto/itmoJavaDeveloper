package com.grudnov.lessons.exam.quest_game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Reciever {
    private Game game;

    public Reciever(Game game) {
        this.game = game;
    }

    public void action(CommandTypes cmd){
        switch (cmd){
            case START:
                game.setItemCounter("Лисенок");
                game.newGame();
                break;
            case CONTINUE:
                try(FileReader fileReader  = new FileReader("sources/save_game.txt")){
                    StringBuilder stringBuilder = new StringBuilder();
                    int c;
                    while((c = fileReader.read()) != -1)
                        stringBuilder.append((char)c);
                    String key = stringBuilder.toString();
                    game.continueGame(key);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case FINISH:
                System.out.println("Игра закончена.");
                System.exit(0);
                break;
            case SAVE:
                try(FileWriter fileWriter  = new FileWriter("sources/save_game.txt"))
                {
                fileWriter.write(game.getItemCounter());
                    System.out.println("Игра сохранена.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
