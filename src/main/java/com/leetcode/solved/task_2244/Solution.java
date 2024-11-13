package com.leetcode.solved.task_2244;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumRounds(int[] tasks) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prior = -1;
        int priorCount = 0;
        int i = 0;
        while (i < tasks.length) {
            if (tasks[i] != prior) {
                if (priorCount > 0) {
                    Integer count = map.get(prior);
                    if (count == null) {
                        count = 0;
                    }
                    count = count + priorCount;
                    if (count == 5) {
                        result++;
                        count = 2;
                    }
                    map.put(prior, count);
                }
                prior = tasks[i];
                priorCount = 1;
            } else {
                priorCount++;
                if (priorCount == 5) {
                    result++;
                    priorCount = 2;
                }
            }
            i++;
        }
        if (priorCount > 0) {
            Integer count = map.get(prior);
            if (count == null) {
                count = 0;
            }
            map.put(prior, count + priorCount);
        }

        for (Integer count : map.values()) {
            if (count == 1) {
                return -1;
            } else if (count == 2) {
                result++;
            } else {
                int rest = count % 3;
                if (rest == 0) {
                    result = result + count / 3;
                } else {
                    result = result + (count - 1) / 3 + 1;
                }
            }
        }
        return result;
    }

}
