package com.grudnov.lessons.exam.quest_game;

public class StartCommand implements Icommand {

    private Reciever reciever;

    public StartCommand(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.action(CommandTypes.START);
    }
}
