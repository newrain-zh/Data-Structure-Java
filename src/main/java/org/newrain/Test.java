package org.newrain;

public class Test {

    public static void main(String[] args) {
        int totalPage = 3;
        int pageSize = 2;
        for (int i = 1; i < totalPage; i++) {
            int start = i * pageSize;
            int end = start + pageSize;
            System.out.println(start + "-" + end);
        }
    }
}