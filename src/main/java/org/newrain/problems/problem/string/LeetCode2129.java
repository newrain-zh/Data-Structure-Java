package org.newrain.problems.problem.string;

/**
 * 将标题首字母大写
 * <a href="https://leetcode.cn/problems/capitalize-the-title/description/">...</a>
 */
public class LeetCode2129 {

    public static String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 2) {
                split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1).toLowerCase();
            } else {
                split[i] = split[i].toLowerCase();
            }
            res.append(split[i]);
            if (i != split.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    /**
     * TODO 优化的方式手动转大小写
     *
     * @param title
     * @return
     */
    public static String capitalizeTitle1(String title) {
        String[] split = title.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String currentStr = split[i];
            currentStr = currentStr.toLowerCase();
            if (currentStr.length() > 2) {
                currentStr = currentStr.substring(0, 1).toUpperCase() + currentStr.substring(1);
            }
            res.append(currentStr);
            if (i != split.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
    }
}