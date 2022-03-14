package z.z.h.unique_paths_with_obstacles_63;

/**
 * @author zzhihua
 * @date 2022/3/14
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    /**
     * 作者：sweetiee
     * 链接：https:
     * //leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 思路：参考62题，思路大体一致；
     * 主要改变
     * for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
     * dp[i][0] = 1;
     * }
     * 当遇到障碍物之后就把之后的路径设置成不可达
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
