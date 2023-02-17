package com.security.securitydemo.command.factory;

public class OffCommand implements  Command{
    @Override
    public void execute() {
        System.out.println("Turn OFF");

    }
}
