package com.app;

public class Main {
    public static void main(String[] args) {
        DeprecatedClass deprecatedClass = new DeprecatedClass();
        deprecatedClass.deprecatedMethod();

        SlowClass slowClass = new SlowClass();
        slowClass.slowMethod();
    }
}