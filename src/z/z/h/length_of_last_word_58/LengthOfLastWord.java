package z.z.h.length_of_last_word_58;

import java.util.Objects;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zzhihua
 * @date 2022/3/8
 */
public class LengthOfLastWord {

    /**
     * 方法一：将字符串以空格进行分割成多个数组，然后反向遍历数组，返回第一个遇到的不是空字符的子串的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (Objects.equals(" ", strings[i])) {
                continue;
            }
            return strings[i].length();
        }
        return -1;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/length-of-last-word/solution/zui-hou-yi-ge-dan-ci-de-chang-du-by-leet-51ih/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 方法二：反向遍历，从第一个不是空格的位置开始技术，直到再次遇见空格为止为最后一个单词的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
