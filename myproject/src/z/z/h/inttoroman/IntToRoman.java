package z.z.h.inttoroman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class IntToRoman {

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : entries) {
            int number = 0;
            number = num / entry.getValue();
            num %= entry.getValue();
            while (number > 0) {
                sb.append(entry.getKey());
                number--;
            }
        }
        return sb.toString();
    }

    /**
     * 方法二 贪心算法代码思路和上面的方法类似
     */
    class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            // Loop through each symbol, stopping if num becomes 0.
            for (int i = 0; i < values.length && num >= 0; i++) {
                // Repeat while the current symbol still fits into num.
                while (values[i] <= num) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }
            return sb.toString();
        }
    }
    

}
