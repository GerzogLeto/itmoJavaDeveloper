package com.grudnov.lessons.exam.quest_game;

public class FinishCommand implements Icommand {
    private Reciever reciever;

    public FinishCommand(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.action(CommandTypes.FINISH);

    }
}
