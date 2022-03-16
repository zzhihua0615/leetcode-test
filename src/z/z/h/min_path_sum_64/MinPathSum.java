package z.z.h.min_path_sum_64;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * @author zzhihua
 * @date 2022/3/16
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }
        int[][] arr = new int[m][n];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            arr[i][0] = grid[i][0] + arr[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            arr[0][i] = grid[0][i] + arr[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
            }
        }
        return arr[m - 1][n - 1];
    }
}
