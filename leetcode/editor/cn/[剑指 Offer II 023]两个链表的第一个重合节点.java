//给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
//
// 
//
// 
// 注意：本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-
//lists/ 
//
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 45, 👎 0 
//
//
//
//

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        
//    }
//
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:两个链表的第一个重合节点
 */
class ThreeU1WK4Case {
    public static void main(String[] args) {
        ThreeU1WK4Case runCase = new ThreeU1WK4Case();

        ListNode p15 = new ListNode(1);
        ListNode p16 = new ListNode(5);
        p15.next = p16;
        ListNode p17 = new ListNode(2);
        ListNode p18 = new ListNode(6);
        ListNode p19 = new ListNode(4);
        p17.next = p18;
        p18.next = p19;
        System.out.println(runCase.threeU1WK4(p15, p17));
    }

    public ListNode threeU1WK4(ListNode headA, ListNode headB) {

        ListNode cur1 = headA, cur2 = headB;
        ListNode cur11, cur22;

        while (cur1 != cur2) {
            if (cur1.next == null && cur2.next != null) cur11 = headB;
            else cur11 = cur1.next;

            if (cur2.next == null && cur1.next != null) cur22 = headA;
            else cur22 = cur2.next;

            cur1 = cur11;
            cur2 = cur22;
        }
        return cur1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
