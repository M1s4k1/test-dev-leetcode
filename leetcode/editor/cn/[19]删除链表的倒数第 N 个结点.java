////给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：head = [1,2,3,4,5], n = 2
////输出：[1,2,3,5]
//// 
////
//// 示例 2： 
////
//// 
////输入：head = [1], n = 1
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：head = [1,2], n = 1
////输出：[1]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 链表中结点的数目为 sz 
//// 1 <= sz <= 30 
//// 0 <= Node.val <= 100 
//// 1 <= n <= sz 
//// 
////
//// 
////
//// 进阶：你能尝试使用一趟扫描实现吗？ 
//// Related Topics链表 | 双指针 
////
//// 👍 2196, 👎 0 
////
////
////
////
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
 * Java:删除链表的倒数第 N 个结点
 */
class RemoveNthNodeFromEndOfListCase {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfListCase runCase = new RemoveNthNodeFromEndOfListCase();

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
        runCase.removeNthNodeFromEndOfList(p1, 2);

        // case2
        // 输入：head = [1], n = 1 输出：[]
        ListNode p6 = new ListNode(1);
        runCase.removeNthNodeFromEndOfList(p6, 1);


        // case2
        // 输入：head = [1], n = 1 输出：[]
        ListNode p7 = new ListNode(1);
        ListNode p8 = new ListNode(2);
        p7.next = p8;
        runCase.removeNthNodeFromEndOfList(p7, 1);

    }

    public ListNode removeNthNodeFromEndOfList(ListNode head, int n) {

        // 删完变成空链表的情况
        if (head.next == null) {
            return null;
        }


        //双指针
        // 原链表长度为l,快指针前进n步,慢指针开始前进
        // 快指针到尾null节点时,前进l-n步
        // 慢指针的位置在[l-n]节点位置,即倒数k的节点位置

        ListNode fast = head;
        ListNode slow = head;

        // 快指针,前进k步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 删除头节点情况
        // l=n 时, 快节点已经到达尾null节点, 慢指针不移动直接删除头节点
        if (fast == null) {
            return head.next;
        }

        // 同时前进l-n步
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
            }
            // 删除节点
            else {
                slow.next = slow.next.next;
            }

        }

        return head;
    }


    public ListNode removeNthNodeFromEndOfList2(ListNode head, int n) {

        // 删完变成空链表的情况
        if (head.next == null) {
            return null;
        }

        // 注意虚拟头节点的使用, 省去了上面代码对头节点的单独处理
        ListNode curHead = new ListNode();
        curHead.next = head;

        // 获得倒数n+1的几点
        ListNode preNode = findFromEnd(curHead, n + 1);

        // 操作删除
        preNode.next = preNode.next.next;

        return curHead.next;
    }

    /**
     * 获得倒数第k个节点
     *
     * @param head 头节点
     * @param n    倒数第k个
     * @return 倒数第k个节点
     */
    private ListNode findFromEnd(ListNode head, int n) {
        // 双指针
        ListNode fast = head;
        ListNode slow = head;

        // 快指针,前进k步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 同时前进l-n步
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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
