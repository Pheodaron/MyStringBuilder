package com.company;

public interface Command {
    default void execute() {
        System.out.println("method not defined");
    }
}
