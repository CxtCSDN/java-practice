package com.cxt.jave.day01;

import java.util.ArrayList;

public class Text {
    public static void main(String[] args){

        final Master master1 = new Master();

        Master master = new Master();
        master.feed(new Cat());
        master.feed(new Bird());

        ArrayList<Integer> array = new ArrayList<Integer>();
    }
}
