package org.example;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("Hello ");
        sb.append("World!");
        System.out.println(sb.toString());

        sb.undo();
        System.out.println(sb.toString());

        sb.append("Всем привет ");
        sb.append("как дела, ");
        sb.append("Мир просто супер");
        System.out.println(sb.toString());

        sb.delete(5, 10);
        System.out.println(sb.toString());

        sb.insert(5, "!");
        System.out.println(sb.toString());
    }
}