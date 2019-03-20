package com.linda.demo.bullCode;

import java.util.HashMap;
import java.util.Map;

public class Duplication {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> duplicated = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!duplicated.containsKey(numbers[i])) {
                duplicated.put(numbers[i], 1);

            } else {
                duplicated.put(numbers[i], duplicated.get(numbers[i]) + 1);
            }
        }
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : duplicated.entrySet()) {
            if (k < duplication.length && entry.getValue() > 1) {
                duplication[k++] = entry.getKey();
                return true;
            }

        }

        return false;
    }


}
