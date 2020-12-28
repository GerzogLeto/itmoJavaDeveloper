package com.grudnov.lessons.exam.quest_game;

public class SaveCommand implements Icommand {
    private Reciever reciever;

    public SaveCommand(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.action(CommandTypes.SAVE);
    }
}
