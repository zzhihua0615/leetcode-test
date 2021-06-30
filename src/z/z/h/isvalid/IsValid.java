package z.z.h.isvalid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zzhihua
 * @date 2021/6/30
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {

    public static void main(String[] args) {

        System.out.println();
    }

    /**
     * 作者：LeetCode - Solution
     * 链接：https:
     * //leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 思路：当遇见左括号时将其入栈，当遇见右括号的时候与栈顶元素判断判断是否闭合。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

/**
 * 另一种比较巧妙的想法：
 * 将对称的括号置空，这样最后如果是有效的括号的话将能变为空字符串
 *
 * @别人的代码，我提交了一遍 执行用时：53 ms, 在所有 Java 提交中击败了5.48%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了5.02%的用户
 */
class Solution {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
        }
        return s.length() == 0;
    }
}
