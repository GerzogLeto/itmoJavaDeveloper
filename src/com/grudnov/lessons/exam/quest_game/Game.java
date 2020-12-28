package com.grudnov.lessons.exam.quest_game;

import java.util.Map;

public class Game {

    ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();
    private String itemCounter;
    private Map<String, StepQuest> mapSteps = StepQuest.getAllStepsQuest();
    private Command command;

    public Game() {
    }

    public void setGameState() {
        Commutator.commute();
        command = new Command(this);
    }

    public void startGame() {
        String input = consoleUserInterface.displayStarterMenu();
        command.defineAndRunCommand(input);

    }

    public void newGame() {

        String str = consoleUserInterface.displayStep(mapSteps.get(itemCounter));
        continueGame(str);
    }

    public void setItemCounter(String itemCounter) {
        this.itemCounter = itemCounter;
    }

    public String getItemCounter() {
        return itemCounter;
    }

    public void continueGame(String str) {
        while (true) {
            if (str.equals("Вы выиграли")) {
                startGame();
                return;
            }
            if (str.equals("Вы проиграли")) {
                startGame();
                return;
            }
            if (str.equals("s")) {
                command.defineAndRunCommand(str);
                command.defineAndRunCommand("3");
                return;
            }
            itemCounter = str;
            continueGame(consoleUserInterface.displayStep(mapSteps.get(itemCounter)));
        }

    }
}
