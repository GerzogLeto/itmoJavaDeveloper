package com.grudnov.lessons.exam.quest_game;

public class Client {
    private Reciever cReciver;

    public Client(Reciever cReciver) {
        this.cReciver = cReciver;
    }

    public Icommand initCommand(CommandTypes cmd){
        Icommand command = null;
        switch (cmd){
            case START:
                command = new StartCommand(cReciver);
                break;
            case CONTINUE:
                command = new ContinueCommand(cReciver);
                break;
            case FINISH:
                command = new FinishCommand(cReciver);
                break;
            case SAVE:
                command = new SaveCommand(cReciver);
                break;
        }
        return command;
    }
}
