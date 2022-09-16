//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 
//
// 👍 855, 👎 0 
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
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:删除排序链表中的重复元素
 */
class RemoveDuplicatesFromSortedListCase {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListCase runCase = new RemoveDuplicatesFromSortedListCase();

        // case1 输入：输入：head = [1,1,2] 输出：[1,2]
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        p1.next = p2;
        p2.next = p3;
        System.out.println(runCase.removeDuplicatesFromSortedList(p1));

        // case2 输入：输入：head = [1,1,2,3,3] 输出：[1,2,3]
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(1);
        ListNode p6 = new ListNode(2);
        ListNode p7 = new ListNode(3);
        ListNode p8 = new ListNode(3);
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        System.out.println(runCase.removeDuplicatesFromSortedList(p4));
    }

    public ListNode removeDuplicatesFromSortedList(ListNode head) {

        // 链表无需排序
        if (head == null || head.next == null) return head;

        // 虚拟头节点
        ListNode preHead = new ListNode();
        preHead.next = head;

        // 双指针处理
        ListNode slow = preHead.next, fast = preHead.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return preHead.next;
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
