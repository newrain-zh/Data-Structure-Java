package org.newrain.example.structure.bloom;

import java.util.BitSet;

/**
 * 自定义过滤器实现
 */
public class BloomFilterExample {
    private final BitSet bitSet;
    private final int size;
    private final int[] hashSeeds;

    public BloomFilterExample(int size, int numHashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashSeeds = generateHashSeeds(numHashFunctions);
    }

    public void add(String element) {
        for (int seed : hashSeeds) {
            int hash = getHash(element, seed);
            bitSet.set(hash);
        }
    }

    public boolean contains(String element) {
        for (int seed : hashSeeds) {
            int hash = getHash(element, seed);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private int getHash(String element, int seed) {
        int hash = seed;
        for (char c : element.toCharArray()) {
            hash = hash * 31 + c;
        }
        return Math.abs(hash % size);
    }

    private int[] generateHashSeeds(int numHashFunctions) {
        int[] seeds = new int[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            seeds[i] = i + 1; // 可以使用不同的随机生成方式生成不同的种子
        }
        return seeds;
    }

    public static void main(String[] args) {
        BloomFilterExample bloomFilter = new BloomFilterExample(100, 3);

        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("orange");

        System.out.println(bloomFilter.contains("apple")); // 输出 true
        System.out.println(bloomFilter.contains("grape")); // 输出 false
    }
}