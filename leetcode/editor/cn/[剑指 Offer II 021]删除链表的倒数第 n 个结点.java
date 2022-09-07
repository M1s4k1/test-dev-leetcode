//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
//
// Related Topics链表 | 双指针 
//
// 👍 51, 👎 0 
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
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 *Java:删除链表的倒数第 n 个结点
 */
class SLwz0RCase {
    public static void main(String[] args) {
        SLwz0RCase runCase = new SLwz0RCase();

        // case1
        //输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        runCase.SLwz0R(p1, 2);

        // case2
        // 输入：head = [1], n = 1 输出：[]
        ListNode p6 = new ListNode(1);
        runCase.SLwz0R(p6, 1);


        // case3
        // 输入：head = [1], n = 1 输出：[]
        ListNode p7 = new ListNode(1);
        ListNode p8 = new ListNode(2);
        p7.next = p8;
        runCase.SLwz0R(p7, 1);
    }

    public ListNode SLwz0R(ListNode head, int n) {
        // 双指针

        if (head == null || head.next == null)
            return null;

        // 涉及删除,需要前一个节点, 需要虚拟头节点
        ListNode preHead = new ListNode();
        preHead.next = head;

        // 快指针指向尾结点null, 慢指针慢n步
        // 操作倒数 n+1个节点删除, 慢指针慢n+1
        ListNode fast = preHead, slow = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

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
