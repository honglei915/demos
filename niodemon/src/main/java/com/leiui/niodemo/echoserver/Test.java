package com.leiui.niodemo.echoserver;

public class Test {

    public static void main(String[] args) {
        String str = "(nihao),(henhao),(nichilema?),(chiguole)";
        String str2 = str.replaceAll("\\(", "~");
        System.out.println(str2);

    }

}
