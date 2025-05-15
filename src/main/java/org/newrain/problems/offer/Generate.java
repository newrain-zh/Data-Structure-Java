package org.newrain.problems.offer;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> generateList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>(i + 1);
            //首位都是0
            for (int j = 0; j <= i; j++) {
                //首和末尾添加1
                if (j == 0 || j == i) {
                    innerList.add(1);
                } else {
                    //上一个数组
                    List<Integer> preList = generateList.get(i - 1);
                    innerList.add(preList.get(j - 1) + preList.get(j));
                }
            }
            generateList.add(innerList);
        }
        return generateList;
    }

    public static void main(String[] args) {
//        generate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 5; j++) {
                System.out.println("j:" + j);
            }
        }
    }
}