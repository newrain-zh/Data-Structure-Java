package org.newrain.example.structure.bloom;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * Bitset使用示例
 */
public class BitSetExample {


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));

    }

    public void test() {
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            int randomResult = random.nextInt(100000000);
            list.add(randomResult);
        }

        BitSet bitSet = new BitSet(100000000);
        for (int i = 0; i < 10000000; i++) {
            bitSet.set(list.get(i));
        }

        System.out.println("0~1亿不在上述随机数中有" + bitSet.cardinality());
        for (int i = 0; i < 100000000; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }
}