package z.z.h.isvalidsudoku;

import java.util.HashMap;

/**
 * @author zzhihua
 * @date 2021/9/10
 */
public class IsValidSudoku {

    /**
     * 思路：在一次便利中判断横向、纵向以及子数独中是否存在重复元素
     * 对于子数独的枚举：
     * box_index = (row / 3) * 3 + columns / 3
     * 通过利用map存储数据在三个纬度中出现的次数，如果出现次数大于1，说明存在重复的元素
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}