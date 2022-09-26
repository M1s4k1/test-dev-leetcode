//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 5723, 👎 0 
//
//
//
//

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String longestPalindrome(String s) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

import java.util.Base64;
import java.util.Objects;

/**
 * Java:最长回文子串
 */
class LongestPalindromicSubstringCase {
    public static void main(String[] args) {
        LongestPalindromicSubstringCase runCase = new LongestPalindromicSubstringCase();

        runCase.longestPalindrome("babad");
        runCase.longestPalindrome("cbbd");

    }

    public String longestPalindrome(String s) {
        // 空字符串/单个字符的场景
        if (s.length() <= 1) return s;

        String sMax="";

        for (int n = 0; n < s.length(); n++) {
            // 获取的字符串
            String s0;

            // 两个展开的指针
            int i = n, t = n+1;

            // 有中间值的回文串
            while (i >= 0 && t < s.length()) {

                // 两个字符如果相同,向两边展开
                if (Objects.equals(s.charAt(i), s.charAt(t))) {
                    i--;
                    t++;
                } else break;
            }
            // 注意这里, 左闭右开哦
            String s1 = s.substring(i + 1, t);

            // 没有中间值的回文串
            i = n;
            t = n;

            // 有中间值的回文串
            while (i >= 0 && t < s.length()) {

                // 两个字符如果相同,向两边展开
                if (Objects.equals(s.charAt(i), s.charAt(t))) {
                    i--;
                    t++;
                } else break;
            }
            // 注意这里, 左闭右开哦
            String s2 = s.substring(i + 1, t);

            if (s1.length() > s2.length()) {
                s0 = s1;
            } else {
                s0 = s2;
            }

            if (sMax.length()<s0.length()){
                sMax=s0;
            }

        }

        System.out.println(sMax);

        return sMax;

    }



}
