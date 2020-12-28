package com.grudnov.lessons.exam.quest_game;

public class Invoker {
    private Icommand mCommand;

    public Invoker(Icommand mCommand) {
        this.mCommand = mCommand;
    }
    public void invokeCommand(){
        mCommand.execute();
    }
}
