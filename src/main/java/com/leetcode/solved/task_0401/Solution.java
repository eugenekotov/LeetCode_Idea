package com.leetcode.solved.task_0401;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn <= 8) {
            work(result, turnedOn, 0, 0, 0);
        }
        return result;
    }

    private void work(List<String> result, int turnedOn, int used, int index, int bits) {
        if (turnedOn == used) {
            // Finished
            int h = getHours(bits);
            if (h < 12) {
                int m = getMins(bits);
                if (m < 60) {
                    String time = getTime(h, m);
                    result.add(time);
                }
            }
        } else {
            if (index < 10) {
                work(result, turnedOn, used, index + 1, bits);
                work(result, turnedOn, used + 1, index + 1, setBit(bits, index));
            }
        }
    }

    private int setBit(int source, int index) {
        return source | (int) Math.pow(2, index);
    }

    private int getHours(int bits) {
        return (bits >> 6);
    }

    private int getMins(int bits) {
        return 63 & bits;
    }

    private String getTime(int h, int m) {
        StringBuilder result = new StringBuilder();
        result.append(h).append(":");
        if (m < 10) {
            result.append("0");
        }
        result.append(m);
        return result.toString();
    }

}
