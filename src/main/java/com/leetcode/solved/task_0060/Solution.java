package com.leetcode.solved.task_0060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        // для кожного регистру починаючи з першого розраховуємо
        // m - раз на скільки ітерацій змінюється число на позиції n, m = (n-1)(n-2)*... *2;
        // b - яке по рахунку число э у відповіді b=(k - 1)/m

        List<Integer> nums = new ArrayList<>(); // цифри, що ще не використані
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int mn2 = 1;
        for (int i = 2; i <= n - 1; i++) {
            mn2 = mn2 * i;
        }
        work(result, nums, n, k, mn2);

        return result.toString();
    }

    private void work(StringBuilder result, List<Integer> nums, int n, int k, int mn2) {
        if (nums.size() == 1) {
            result.append(nums.get(0));
        } else if (nums.size() == 2) {
            // Generate 1 and 2 symbols;
            if ((k % 2) != 0) {
                result.append(nums.get(0)).append(nums.get(1));
            } else {
                result.append(nums.get(1)).append(nums.get(0));
            }
        } else {
            int m = mn2;
            if (nums.size() > 2) {
                mn2 = m / (nums.size() - 1); // for next register
            }
            int b = (k - 1) / m; // кількість змін
            int res = nums.get(b);
            result.append(res);
            nums.remove(Integer.valueOf(res));
            if (m < k) {
                k = (k - 1) % m + 1;
            }
            work(result, nums, n, k, mn2);
        }
    }

}
