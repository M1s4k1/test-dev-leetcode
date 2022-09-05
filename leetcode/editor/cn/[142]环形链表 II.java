//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
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
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 1762, 👎 0 
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
 * Java:环形链表 II
 */
class LinkedListCycleIiCase {
    public static void main(String[] args) {
        LinkedListCycleIiCase runCase = new LinkedListCycleIiCase();

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
        System.out.println(runCase.linkedListCycleIi(p1));

        // case2
        // 输入：head = [1,2], pos = 0 输出：返回索引为 0 的链表节点
        ListNode p5 = new ListNode(1);
        ListNode p6 = new ListNode(2);
        p5.next = p6;
        p6.next = p5;
        System.out.println(runCase.linkedListCycleIi(p5));

        // case3
        // 输入：输入：head = [1], pos = -1 输出：返回 null
        ListNode p7 = new ListNode(1);
        System.out.println(runCase.linkedListCycleIi(p7));

    }

    public ListNode linkedListCycleIi(ListNode head) {

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
            return null;
        } else {
            // 此时两个指针已经相遇
            // 慢指针前进k步,快指针前进2k步
            // 2k-k=k, k为环长度的整数倍
            // 以相遇点到环起点,距离为m, 链表头节点到环起点为k-m, 慢指针重置到头节点,每次一步,前进k-m步
            // k为环长度的整数倍,m一定小于环长, 相遇点距换起点为k-m, 每次一次,快指针前进k-m步
            // 快慢指针下一次会在环起点相遇

            // 重置慢节点
            slow = head;
            // 直到相遇
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
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
