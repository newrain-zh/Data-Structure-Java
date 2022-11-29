package org.newrain.code.offer;

public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (!s.contains(" ")) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c==' '){
                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
