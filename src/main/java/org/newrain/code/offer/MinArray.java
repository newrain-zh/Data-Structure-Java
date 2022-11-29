package org.newrain.code.offer;

import java.util.Arrays;

public class MinArray {

    public static int minArray(int[] numbers) {
        return Arrays.stream(numbers).min().orElse(0);
    }
}
