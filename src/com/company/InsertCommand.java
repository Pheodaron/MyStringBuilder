package com.company;

public class InsertCommand implements Command{

    StringBuilder stringBuilder;

    public InsertCommand(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void execute(int offset, String str) {
        stringBuilder.insert(offset, str);
    }
}
