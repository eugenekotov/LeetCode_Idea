package com.leetcode.inprogress.task_0043;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String multiply(String num1, String num2) {
        List<List<Integer>> registers = new ArrayList<>();
        for (int i2 = 0; i2 < num2.length(); i2++) {
            for (int i1 = 0; i1 < num1.length(); i1++) {
                if (registers.size() - 1 < i2) {
                    registers.add(new ArrayList<>());
                }
                List<Integer> registerI = registers.get(i2);
                if (registerI.size() - 1 < i1) {
                    registerI.add(0);
                }
                int register = registerI.get(i1);
                int n1 = Character.getNumericValue(num1.charAt(num1.length() - 1 - i1));
                int n2 = Character.getNumericValue(num2.charAt(num2.length() - 1 - i2));
                register = register + n1 * n2;
                registerI.set(i1, register % 10);
                int nextRegister = register / 10;
                if (nextRegister > 0) {
                    registerI.add(register / 10);
                }
            }
        }
        // sum
        StringBuilder result = new StringBuilder();
        int i = 0;  // index from left to right
        boolean shouldContinue = registers.size() > i;
        int reg = 0;
        while (shouldContinue) {
            shouldContinue = false;
            for (int index = 0; index <= i; index++) { // index number of line
                if (registers.size() > index) {
                    List<Integer> registerLine = registers.get(index);
                    int indexInLine = i - index;
                    if (registerLine.size() > indexInLine) {
                        shouldContinue = true;
                        reg = reg + registerLine.get(indexInLine);
                    }
                }
            }
            if (reg != 0 || shouldContinue) {
                result.insert(0, reg % 10);
                reg = reg / 10;
            }
            i++;
        }
        String r = result.toString();
        i = 0;
        while (r.length() - i > 1 && r.charAt(i) == '0') {
            i++;
        }
        if (i>0) {
            r = r.substring(i);
        }
        return r;
    }
}
