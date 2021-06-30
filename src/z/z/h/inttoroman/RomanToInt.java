package z.z.h.inttoroman;

/**
 * 将罗马数字转为整数表示
 *
 * @author zzhihua
 * @date 2021/4/22
 */
public class RomanToInt {


    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int[] num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        s = s + "=";
        int number = 0;
        int i = 0;
        while (s.length() > 1) {
            if (s.startsWith(roman[i])) {
                number += num[i];
                s = s.substring(roman[i].length(), s.length());
            } else {
                i++;
            }
        }
        return number;
    }
}

/**
 * 方法二 把小的数放在大的数的左边则做减法，否则为加法
 */
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}