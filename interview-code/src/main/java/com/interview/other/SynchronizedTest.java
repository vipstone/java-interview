package com.interview.other;

public class SynchronizedTest {
    public static void main(String[] args) {
        synchronized (SynchronizedTest.class) {
            System.out.println("Java");
        }
    }
}
