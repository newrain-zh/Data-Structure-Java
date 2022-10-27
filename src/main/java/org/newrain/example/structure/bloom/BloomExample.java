package org.newrain.example.structure.bloom;

import java.util.BitSet;

/**
 * @author newRain
 * @description 布隆过滤器简单实现
 */
public class BloomExample {

    private int m = 128;
    private BitSet bitSet = new BitSet(m);
    private final int[] hashs = {1, 9, 11, 22, 31};

    void setHashValue(String string) {
        for (int i = 0; i < hashs.length; i++) {
            int result = 0;
            for (int j = 0; j < string.length(); j++) {
                result = hashs[i] * result + string.charAt(i);
                if (result > m) {
                    result = result % m;
                }
            }
            bitSet.set(result, true);
        }
    }

    boolean has(String string) {
        for (int i = 0; i < hashs.length; i++) {
            int result = 0;
            for (int j = 0; j < string.length(); j++) {
                result = hashs[i] * result + string.charAt(i);
                if (result > m) {
                    result = result % m;
                }
            }
            if (!bitSet.get(result)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomExample bloomTest = new BloomExample();
        bloomTest.setHashValue("zhangshang");
        bloomTest.setHashValue("wangwu");
        bloomTest.setHashValue("hello");
        System.out.println(bloomTest.has("zhangshang"));
        System.out.println(bloomTest.has("wangwu"));
        System.out.println(bloomTest.has("hello"));
        System.out.println(bloomTest.has("hello1"));
    }

}
