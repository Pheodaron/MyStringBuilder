package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        StrBuilder a = new StrBuilder();


        a.insert(a.toString().length(), "a");
        a.insert(a.toString().length(), "b");
        a.insert(a.toString().length(), "c");
        a.insert(a.toString().length(), "d");
        a.insert(a.toString().length(), "e");
        a.insert(a.toString().length(), "f");
        a.insert(a.toString().length(), "g");

        System.out.println(a.toString());

        a.undo();
        a.undo();

        System.out.println(a.toString());

        a.delete(a.toString().length() - 1, a.toString().length());
        a.delete(a.toString().length() - 1, a.toString().length());

        System.out.println(a.toString());

        a.undo();
        a.undo();

        System.out.println(a.toString());

    }
}

