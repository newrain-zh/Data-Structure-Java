package org.newrain.problems.problem.array;

/**
 * 去掉最低工资和最高工资后的工资平均值
 */
public class Average {


    public static double average(int[] salary) {
        int max = salary[0], min = salary[0];
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] > max) {
                max = salary[i];
            }
            if (salary[i] < min) {
                min = salary[i];
            }
        }
        int sum = 0;
        for (int j : salary) {
            if (j != max && j != min) {
                sum += j;
            }
        }
        return (double) sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
    }
}