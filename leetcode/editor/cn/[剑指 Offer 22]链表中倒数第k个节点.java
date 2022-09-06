//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
//
// Related Topics链表 | 双指针 
//
// 👍 393, 👎 0 
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
 * ListNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public ListNode getKthFromEnd(ListNode head, int k) {
//
//    }

//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:链表中倒数第k个节点
 */
class LianBiaoZhongDaoShuDiKgeJieDianLcofCase {
    public static void main(String[] args) {
        LianBiaoZhongDaoShuDiKgeJieDianLcofCase runCase = new LianBiaoZhongDaoShuDiKgeJieDianLcofCase();

        // case1
        //给定一个链表: 1->2->3->4->5, 和 k = 2. 返回链表 4->5.
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        runCase.lianBiaoZhongDaoShuDiKgeJieDianLcof(p1, 2);
    }

    public ListNode lianBiaoZhongDaoShuDiKgeJieDianLcof(ListNode head, int k) {

        // 双指针,间隔为k-1,多走k步
        // 快指针在尾null, 慢指针在倒数k
        ListNode fast = head, slow = head;

        // 先移动快指针
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 同时移动双指针,直到fast==null
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
