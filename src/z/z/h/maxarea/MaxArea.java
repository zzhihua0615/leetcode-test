package z.z.h.maxarea;

public class MaxArea {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(maxArea(arr));
        System.out.println(maxArea2(arr));
    }

    /**
     * 暴力解法：直接对数组进行遍历，每次遍历根据长度和宽度获得当前的容量并求得最大容量
     * 但此算法效率较低
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int length = 0;
        int width = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                length = j - i;
                width = Math.min(minHeight, height[j]);
                max = Math.max(max, length * width);
            }
        }
        return max;
    }

    /**
     * 方法二：采用双指针的方式，开始时指针分别位于左右两边，并移动高度较低的部分
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            max = Math.max(max, width * length);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
