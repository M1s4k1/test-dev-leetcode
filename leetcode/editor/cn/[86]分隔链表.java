//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [2,1], x = 2
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics链表 | 双指针
//
// 👍 617, 👎 0
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
//    public ListNode partition(ListNode head, int x) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;


/**
 * Java:分隔链表
 */
class PartitionListCase {
    public static void main(String[] args) {
        PartitionListCase runCase = new PartitionListCase();

        // case1 输入：head = [1,4,3,2,5,2], x = 3 输出：[1,2,2,4,3,5]
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(2);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(2);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        System.out.println(runCase.partitionList(h1, 3));


        // case1 输入：head = [2,1], x = 2 输出：[1,2]
        ListNode h7 = new ListNode(2);
        ListNode h8 = new ListNode(1);
        h7.next = h8;
        System.out.println(runCase.partitionList(h7, 2));

    }

    public ListNode partitionList(ListNode head, int x) {

        //空链表
        if (head == null) {
            return null;
        }
        // 长度为1的
        else if (head.next == null) {
            return head;
        }
        //一般情况
        else {

            // 开两个新链表,一个储存小于x节点,一个储存大于等于x节点
            // 两个头节点
            ListNode lessList = new ListNode(), lessHead = lessList;
            ListNode greatList = new ListNode(), greatHead = greatList;

            // 遍历临时节点
            ListNode curNode = head;

            while (curNode != null) {

                // 连接到小链表
                if (curNode.val < x) {
                    lessList.next = curNode;
                    lessList = lessList.next;
                }
                // 连接都大链表
                else {
                    greatList.next = curNode;
                    greatList = greatList.next;
                }

                // 移动原链表
                curNode = curNode.next;
            }

            // 连接大链表到小链表后面
            lessList.next = greatHead.next;
            // 大链表确认末尾断开
            greatList.next = null;

            return lessHead.next;

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

