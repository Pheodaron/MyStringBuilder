package com.company;

import java.util.Stack;

public class StrBuilder {
    StringBuilder stringBuilder = new StringBuilder();
    Stack<Command> commands = new Stack<>();

    InsertCommand insertCommand = new InsertCommand(stringBuilder);
    DeleteCommand deleteCommand = new DeleteCommand(stringBuilder);

    public void insert(int offset,String str) {
        insertCommand.execute(offset, str);

        Command cmd = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };
        commands.add(cmd);
    }

    public void delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        deleteCommand.execute(start, end);
        Command cmd = new Command() {
            @Override
            public void execute() {
            stringBuilder.insert(start, deleted);
            }
        };
        commands.add(cmd);
    }

    //other methods
    public void undo() {
        if(!commands.isEmpty()) {
            commands.pop().execute();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
