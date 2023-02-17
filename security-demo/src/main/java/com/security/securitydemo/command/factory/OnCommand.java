package com.security.securitydemo.command.factory;

public class OnCommand implements  Command{
    @Override
    public void execute() {
        System.out.println("Turn ON");
    }
}
