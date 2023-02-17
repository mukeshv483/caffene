package com.security.securitydemo.command.factory;

public class CommandFactory {
    Command command;

    public CommandFactory(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }

}
