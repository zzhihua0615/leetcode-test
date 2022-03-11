package z.z.h.unique_paths_62;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zzhihua
 * @date 2022/3/11
 */
public class UniquePaths {

    /**
     * 我们用 f(i,j)f(i, j)f(i,j) 表示从左上角走到 (i,j)(i, j)(i,j) 的路径数量，其中 iii 和 jjj 的范围分别是 [0,m)[0, m)[0,m) 和 [0,n)[0, n)[0,n)。
     * <p>
     * 由于我们每一步只能从向下或者向右移动一步，因此要想走到 (i,j)(i, j)(i,j)，如果向下走一步，那么会从 (i−1,j)(i-1, j)(i−1,j) 走过来；如果向右走一步，那么会从 (i,j−1)(i, j-1)(i,j−1) 走过来。因此我们可以写出动态规划转移方程：
     * <p>
     * f(i,j)=f(i−1,j)+f(i,j−1)f(i, j) = f(i-1, j) + f(i, j-1) f(i,j)=f(i−1,j)+f(i,j−1)
     * <p>
     * 需要注意的是，如果 i=0i=0i=0，那么 f(i−1,j)f(i-1,j)f(i−1,j) 并不是一个满足要求的状态，我们需要忽略这一项；同理，如果 j=0j=0j=0，那么 f(i,j−1)f(i,j-1)f(i,j−1) 并不是一个满足要求的状态，我们需要忽略这一项。
     * <p>
     * 初始条件为 f(0,0)=1f(0,0)=1f(0,0)=1，即从左上角走到左上角有一种方法。
     * <p>
     * 最终的答案即为 f(m−1,n−1)f(m-1,n-1)f(m−1,n−1)。
     * <p>
     * 为了方便代码编写，我们可以将所有的 f(0,j)f(0, j)f(0,j) 以及 f(i,0)f(i, 0)f(i,0) 都设置为边界条件，它们的值均为 111。
     * <p>
     * 作者：LeetCode - Solution
     * 链接：https:
     * //leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 思路：列出每个地点的坐标，每个坐标的值是到该坐标的可能行，则f[m - 1][n - 1]就是到目标位置一共有集中可能性
     * 因为只能向下或向右走，所以当前节点的可能性等于上方节点的可能性与左边节点的可能性之和
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


}
