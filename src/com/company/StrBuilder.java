package com.company;

import java.util.Stack;

public class StrBuilder {
    StringBuilder stringBuilder = new StringBuilder();
    Stack<Command> commands = null;

    /**
     *Конструкторы
     */
    public StrBuilder(String str) {
        commands = new Stack<>();
        //stringBuilder.append(str);
        this.append(str);
    }

    public StrBuilder() {
        commands = new Stack<>();
    }

    public StrBuilder insert(int offset,String str) {
        InsertCommand insertCommand = new InsertCommand(stringBuilder, offset, str);
        insertCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };
        commands.add(cmd);
        return this;
    }

    public StrBuilder delete(int start, int end) {
        DeleteCommand deleteCommand = new DeleteCommand(stringBuilder, start, end);
        String deleted = stringBuilder.substring(start, end);
        deleteCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
            stringBuilder.insert(start, deleted);
            }
        };
        commands.add(cmd);
        return this;
    }

    public StrBuilder append(String str) {
        AppendCommand appendCommand = new AppendCommand(stringBuilder, str);
        appendCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length());
            }
        };
        commands.add(cmd);
        return this;
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
