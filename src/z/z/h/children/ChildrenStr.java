package z.z.h.children;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class ChildrenStr {

    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    /**
     * 方式一
     * 暴力一点，两次循环，类似99乘法表
     * 利用s.subString(int begin,int end)和s.contains(s)获得最长的子串
     * 注意：当s中最后一个字符和前面的子串不冲突时，此时maxLength应+1
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        if ("".equals(s)) {
            return 0;
        }
/*        if (" ".equals(s)) {
            return 1;
        }*/
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                //获取前i个元素
                String children = s.substring(i, j);
                //如果前i个元素和下一个元素不冲突，则最长子串长度+1
                if (children.contains(s.substring(j, j + 1))) {
                    maxLength = maxLength > children.length() ? maxLength : children.length();
                    break;
                }
                //当最后一个元素和之前的元素不重复时，子串长度+1
                if (j == s.length() - 1 && !children.contains(s.substring(j, j + 1))) {
                    children = s.substring(i, j + 1);
                    maxLength = maxLength > children.length() ? maxLength : children.length();
                }
            }
        }
        return maxLength;
    }

    /**
     * 方式二
     * 利用集合的contains方法
     * 只需遍历一次，下次遍历开始时将加入到集合中的第一个元素删除
     * 而且每次遍历判断元素是否重复不需要重头开始，只需要重上次重复处开始
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        int endIndex = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (0 != i) {
                set.remove(s.charAt(i - 1));
            }
            //往set中添加元素，直到遇到重复元素为止
            while (endIndex + 1 < s.length() && !set.contains(s.charAt(endIndex + 1))) {
                set.add(s.charAt(endIndex + 1));
                endIndex++;
            }
            maxLength = Math.max(maxLength, endIndex - i + 1);
        }
        return maxLength;
    }
}
