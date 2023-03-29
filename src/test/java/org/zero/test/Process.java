package org.zero.test;

public class Process {
    public static void main(String[] args) {
        ProcessHandle handle = ProcessHandle.current();
        System.out.println(handle.info());
        Rectangle a = new Rectangle(10, 20);
        System.out.println("a: " + a.a() + ", b: " + a.b() + ", area: " + a.area());

    }
}

record Rectangle(int a, int b) {
    public int area() {
        return a * b;
    }
}