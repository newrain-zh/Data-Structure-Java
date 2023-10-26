package org.newrain.code.problem.array;

public class ShortestDistance {


    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != Integer.MAX_VALUE && index2 != Integer.MAX_VALUE) {
                res = Math.min(Math.abs(index1 - index2), res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = shortestDistance(new String[]{"this", "is", "a", "long", "sentence", "is", "fun", "day", "today", "sunny", "weather", "is", "a", "day", "tuesday", "this", "sentence", "run", "running", "rainy"}, "this", "rainy");
        System.out.println(res);
    }

}