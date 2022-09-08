//给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，
//pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：是否可以使用 O(1) 空间解决此题？ 
//
// 
//
// 
// 注意：本题与主站 142 题相同： https://leetcode-cn.com/problems/linked-list-cycle-ii/ 
//
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 75, 👎 0 
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
//    public ListNode detectCycle(ListNode head) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:链表中环的入口节点
 */
class C32eOVCase {
    public static void main(String[] args) {
        C32eOVCase runCase = new C32eOVCase();
        // case1
        // 输入：head = [3,2,0,-4], pos = 1 输出：返回索引为 1 的链表节点
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p2;
        System.out.println(runCase.c32eOV(p1));

        // case2
        // 输入：head = [1,2], pos = 0 输出：返回索引为 0 的链表节点
        ListNode p5 = new ListNode(1);
        ListNode p6 = new ListNode(2);
        p5.next = p6;
        p6.next = p5;
        System.out.println(runCase.c32eOV(p5));

        // case3
        // 输入：输入：head = [1], pos = -1 输出：返回 null
        ListNode p7 = new ListNode(1);
        System.out.println(runCase.c32eOV(p7));
    }

    public ListNode c32eOV(ListNode head) {

        ListNode cur1 = head, cur2 = head;

        while (cur1 != null && cur1.next != null) {
            cur1 = cur1.next.next;
            cur2 = cur2.next;
            if (cur1 == cur2) {
                break;
            }
        }
        if (cur1 == null || cur1.next == null) {
            return null;
        } else {
            cur2 = head;
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
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
