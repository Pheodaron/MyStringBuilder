package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        StrBuilder a = new StrBuilder();
        StrBuilder b = new StrBuilder("Babka-abobka");

        System.out.println(a.toString());
        System.out.println(b.toString());

        b.undo();

        System.out.println(b.toString());

        b.undo();
        b.undo();

    }
}

