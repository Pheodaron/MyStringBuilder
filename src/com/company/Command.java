package com.company;

public interface Command {
    default void execute() {
        System.out.println("method not defined");
    }
    default void execute(int offset, String str) {
        System.out.println("method not defined");
    }
    default void execute(int start, int end) {
        System.out.println("method not defined");
    }
}
