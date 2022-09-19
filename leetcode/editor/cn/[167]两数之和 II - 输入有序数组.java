////给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
////两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
////length 。
////
//// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
////
//// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
////
//// 你所设计的解决方案必须只使用常量级的额外空间。
////
//// 示例 1：
////
////
////输入：numbers = [2,7,11,15], target = 9
////输出：[1,2]
////解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
////
//// 示例 2：
////
////
////输入：numbers = [2,3,4], target = 6
////输出：[1,3]
////解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
////
//// 示例 3：
////
////
////输入：numbers = [-1,0], target = -1
////输出：[1,2]
////解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
////
////
////
////
//// 提示：
////
////
//// 2 <= numbers.length <= 3 * 10⁴
//// -1000 <= numbers[i] <= 1000
//// numbers 按 非递减顺序 排列
//// -1000 <= target <= 1000
//// 仅存在一个有效答案
////
////
//// Related Topics数组 | 双指针 | 二分查找
////
//// 👍 892, 👎 0
////
////
////
////
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:两数之和 II - 输入有序数组
 */
class TwoSumIiInputArrayIsSortedCase {
    public static void main(String[] args) {
        TwoSumIiInputArrayIsSortedCase runCase = new TwoSumIiInputArrayIsSortedCase();

        // case1:输入：numbers = [2,7,11,15], target = 9 输出：[1,2]
        int[] case1 = {2, 7, 11, 15};
        runCase.twoSumIiInputArrayIsSorted(case1, 9);

        // case2:输入：numbers = [2,3,4], target = 6 输出：[1,3]
        int[] case2 = {2, 3, 4};
        runCase.twoSumIiInputArrayIsSorted(case2, 6);

        // case3:输入：numbers = [-1,0], target = -1 输出：[1,2]
        int[] case3 = {-1, 0};
        runCase.twoSumIiInputArrayIsSorted(case3, -1);
    }

    public int[] twoSumIiInputArrayIsSorted(int[] numbers, int target) {

        // 起点指针
        int i = 0;
        // 终点指针
        int t = numbers.length - 1;

        // 逼近中间值,逐行/逐列缩小
        while (i < t) {

            // 每次都是以右上角的值来进行比较
            // 右上角值 i最小,t最大
            // 右上角值 > tar 时, i最小,t最大 (i不能减小,t可以减小), 则t指针-1, 缩小一列,
            // 右上角值 < tar 时, i最小,t最大 (i可以增大,t不能增大), 则i指针+1, 缩小一行,

            if (numbers[i] + numbers[t] > target) {
                t = t - 1;
            } else if (numbers[i] + numbers[t] < target) {
                i = i + 1;
            } else {
                return new int[]{i + 1, t + 1};
            }
        }
        return new int[]{-1, -1};

    }

}
