package org.newrain.problems.problem.utils;

public class ArrayVisualizer {

    public static void main(String[] args) {
        // 示例数组（支持任意数据类型）
        Integer[][] intArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        String[][] strArray = {
                {"Java", "Python", "C++"},
                {"Ruby", "Go", "Rust"}
        };

        System.out.println("整数数组:");
        visualizeArray(intArray);

        System.out.println("\n字符串数组:");
        visualizeArray(strArray);
    }

    // 通用可视化方法
    public static <T> void visualizeArray(T[][] array) {
        if (array == null || array.length == 0) {
            System.out.println("空数组");
            return;
        }

        final int cols = array[0].length;
        final String horizontalLine = createHorizontalLine(cols);
        final String header = createColumnHeader(cols);

        System.out.println(header);
        System.out.println(horizontalLine);

        for (int row = 0; row < array.length; row++) {
            StringBuilder sb = new StringBuilder()
                    .append(row).append(" |");

            for (T item : array[row]) {
                String content = formatItem(item);
                sb.append(content).append("|");
            }

            System.out.println(sb);
            System.out.println(horizontalLine);
        }
    }

    // 创建列标题（A,B,C...）
    private static String createColumnHeader(int cols) {
        StringBuilder sb = new StringBuilder("    ");
        for (int i = 0; i < cols; i++) {
            char colChar = (char) ('A' + i);
            sb.append(String.format("%-4s", colChar));
        }
        return sb.toString().trim();
    }

    // 创建水平分割线
    private static String createHorizontalLine(int cols) {
        StringBuilder sb = new StringBuilder("  +");
        for (int i = 0; i < cols; i++) {
            sb.append("---+");
        }
        return sb.toString();
    }

    // 格式化单元格内容（自动对齐）
    private static <T> String formatItem(T item) {
        if (item == null) return "   ";
        if (item instanceof Number) {
            return String.format("%3s", item); // 数字右对齐
        }
        return String.format("%-3s", item);    // 文本左对齐
    }
}