package com.company;

public class DeleteCommand implements Command {
    StringBuilder stringBuilder;

    public DeleteCommand(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void execute(int start, int end) {
        stringBuilder.delete(start, end);
    }
}
