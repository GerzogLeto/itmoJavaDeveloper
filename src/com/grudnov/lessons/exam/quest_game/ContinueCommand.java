package com.grudnov.lessons.exam.quest_game;

public class ContinueCommand implements Icommand {

    private Reciever reciever;

    public ContinueCommand(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.action(CommandTypes.CONTINUE);
    }
}
