//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 1740, 👎 0 
//
//
//
//

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public void moveZeroes(int[] nums) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:移动零
 */
class MoveZeroesCase {
    public static void main(String[] args) {
        MoveZeroesCase runCase = new MoveZeroesCase();

        // case1:输入: nums = [0,1,0,3,12] 输出: [1,3,12,0,0]
        int[] nums1 = {0,1,0,3,12};
        runCase.moveZeroes(nums1);

        // case1:输入: nums = [0] 输出: [0]
        int[] nums2 = {0};
        runCase.moveZeroes(nums2);
    }

    public void moveZeroes(int[] nums) {

        // 慢指针
        int k = 0;

        // 快指针遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        // 0值处理
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

}
