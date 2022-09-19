//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
//
// Related Topics递归 | 双指针 | 字符串 
//
// 👍 664, 👎 0 
//
//
//
//

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public void reverseString(char[] s) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:反转字符串
 */
class ReverseStringCase {
    public static void main(String[] args) {
        ReverseStringCase runCase = new ReverseStringCase();

        // case1: 输入：s = ["h","e","l","l","o"] 输出：["o","l","l","e","h"]
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        runCase.reverseString(s1);

        // case1: 输入：s = ["H","a","n","n","a","h"] 输出：["o","l","l","e","h"]
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        runCase.reverseString(s2);
    }

    public void reverseString(char[] s) {

        // 双指针
        int i = 0, t = s.length - 1;

        // 对向移动,交换
        while (i <= t) {
            char temp = s[i];
            s[i] = s[t];
            s[t] = temp;
            i++;
            t--;
        }
        System.out.println();
    }

}
