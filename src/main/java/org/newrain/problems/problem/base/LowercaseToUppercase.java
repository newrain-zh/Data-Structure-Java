package org.newrain.problems.problem.base;

public class LowercaseToUppercase {


    public static char lowercaseToUppercase(char c) {
        c ^= 32;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(lowercaseToUppercase('a'));
    }
}