//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 1605, 👎 0 
//
//
//
//

//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
//public class Solution {
//    public boolean hasCycle(ListNode head) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:环形链表
 */
class LinkedListCycleCase {
    public static void main(String[] args) {
        LinkedListCycleCase runCase = new LinkedListCycleCase();

        // case2
        // 输入：head = [3,2,0,-4], pos = 1 输出：true
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p2;
        System.out.println(runCase.linkedListCycle(p1));

        // case2
        // 输入：head = [1,2], pos = 0 输出：true
        ListNode p5 = new ListNode(1);
        ListNode p6 = new ListNode(2);
        p5.next = p6;
        p6.next = p5;
        System.out.println(runCase.linkedListCycle(p5));

        // case2
        // 输入：head = [1], pos = -1 输出：false
        ListNode p7 = new ListNode(1);
        System.out.println(runCase.linkedListCycle(p7));

    }

    public boolean linkedListCycle(ListNode head) {

        // 快慢指针, 快指针步长是慢指针整数倍
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return false;
        } else {
            return true;
        }
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
