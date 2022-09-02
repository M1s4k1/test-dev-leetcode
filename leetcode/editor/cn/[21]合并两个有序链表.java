////////////////////将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
////////////////////
//////////////////// 
////////////////////
//////////////////// 示例 1： 
////////////////////
//////////////////// 
////////////////////输入：l1 = [1,2,4], l2 = [1,3,4]
////////////////////输出：[1,1,2,3,4,4]
//////////////////// 
////////////////////
//////////////////// 示例 2： 
////////////////////
//////////////////// 
////////////////////输入：l1 = [], l2 = []
////////////////////输出：[]
//////////////////// 
////////////////////
//////////////////// 示例 3： 
////////////////////
//////////////////// 
////////////////////输入：l1 = [], l2 = [0]
////////////////////输出：[0]
//////////////////// 
////////////////////
//////////////////// 
////////////////////
//////////////////// 提示： 
////////////////////
//////////////////// 
//////////////////// 两个链表的节点数目范围是 [0, 50] 
//////////////////// -100 <= Node.val <= 100 
//////////////////// l1 和 l2 均按 非递减顺序 排列 
//////////////////// 
//////////////////// Related Topics递归 | 链表 
////////////////////
//////////////////// 👍 2653, 👎 0 
////////////////////
////////////////////
////////////////////
////////////////////
//////////////////
////////////////
//////////////
////////////
//////////
////////
//////
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
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
//


package editor.cn;


/**
 * Java:合并两个有序链表
 * 将两个有序链表,合并为一个有序链表
 * 算法: 双指针,拉链
 */
class MergeTwoSortedListsCase {
    public static void main(String[] args) {
        MergeTwoSortedListsCase runCase = new MergeTwoSortedListsCase();


        // case1
        //输入：l1 = [1,2,4], l2 = [1,3,4] 输出：[1,1,2,3,4,4]
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;

        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(3);
        ListNode p6 = new ListNode(4);
        p4.next = p5;
        p5.next = p6;

        runCase.mergeTwoSortedLists(p1, p4);


        // case2
        // 输入：l1 = [], l2 = [] 输出：[]
        runCase.mergeTwoSortedLists(null, null);

        // case3
        // 输入：l1 = [], l2 = [0] 输出：[0]
        runCase.mergeTwoSortedLists(null, new ListNode(0));

    }

    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {

        // 用于返回的新链表,头节点占位
        ListNode newListNode = new ListNode();
        // 存储用于返回新链表的头节点
        ListNode newHead = newListNode;


        // 从头开始同时遍历两个链表,每次取两个当前节点中的小值
        // 大值的节点不移动,小值的节点向后移动
        // 再次比较两个节点
        ListNode curList1 = list1;
        ListNode curList2 = list2;

        while (curList1 != null && curList2 != null) {

            // 值小的放入新链表,指针移动
            if (curList1.val >= curList2.val) {
                newListNode.next = curList2;
                curList2 = curList2.next;
            } else {
                newListNode.next = curList1;
                curList1 = curList1.next;
            }

            // 新链表指针移动
            newListNode = newListNode.next;
        }

        if (curList1 == null) {
            newListNode.next = curList2;
        } else {
            newListNode.next = curList1;
        }


        return newHead.next;
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


