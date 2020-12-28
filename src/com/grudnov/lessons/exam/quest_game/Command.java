package com.grudnov.lessons.exam.quest_game;

public class Command {
private Game game;
private Reciever reciever;
private Client client;
    public Command(Game game) {
        this.game = game;
        this.reciever = new Reciever(game);
        this.client = new Client(reciever);
    }
    public void defineAndRunCommand(String str){
        switch(str){
            case "1":
                Icommand commandStart = client.initCommand(CommandTypes.START);
                Invoker invokerStart = new Invoker(commandStart);
                invokerStart.invokeCommand();
                break;
            case "2":
                Icommand commandContinue = client.initCommand(CommandTypes.CONTINUE);
                Invoker invokerContinue = new Invoker(commandContinue);
                invokerContinue.invokeCommand();
                break;
            case "3":
                Icommand commandFinish = client.initCommand(CommandTypes.FINISH);
                Invoker invokerFinish = new Invoker(commandFinish);
                invokerFinish.invokeCommand();
                break;
            case "s":
                Icommand commandSave = client.initCommand(CommandTypes.SAVE);
                Invoker invokerSave = new Invoker(commandSave);
                invokerSave.invokeCommand();
                break;
        }
    }




}
