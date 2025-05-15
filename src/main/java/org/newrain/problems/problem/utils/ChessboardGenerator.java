package org.newrain.problems.problem.utils;

public class ChessboardGenerator {

    public static void main(String[] args) {
        printChessboard(4); // 生成 8x8 棋盘
    }

    // 生成指定尺寸的棋盘
    public static void printChessboard(int size) {
        if (size <= 0) {
            System.out.println("棋盘尺寸必须大于0");
            return;
        }

        String horizontalLine = createHorizontalLine(size);
        String verticalLine = createVerticalLine(size);

        for (int row = 0; row < size; row++) {
            System.out.println(horizontalLine);
            System.out.println(verticalLine);
        }
        System.out.println(horizontalLine); // 底部边界
    }

    // 创建水平分割线 (示例: +---+---+---+)
    private static String createHorizontalLine(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("+------");
        }
        sb.append("+"); // 行尾闭合
        return sb.toString();
    }

    // 创建垂直单元格线 (示例: |   |   |   |)
    private static String createVerticalLine(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("|      ");
        }
        sb.append("|"); // 行尾闭合
        return sb.toString();
    }
}