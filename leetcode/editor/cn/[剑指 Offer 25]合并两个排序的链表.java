//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics递归 | 链表 
//
// 👍 273, 👎 0 
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
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//    }

//import editor.cn.LianBiaoZhongDaoShuDiKgeJieDianLcofCase;}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:合并两个排序的链表
 */
class HeBingLiangGePaiXuDeLianBiaoLcofCase {
    public static void main(String[] args) {
        HeBingLiangGePaiXuDeLianBiaoLcofCase runCase = new HeBingLiangGePaiXuDeLianBiaoLcofCase();


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

        runCase.heBingLiangGePaiXuDeLianBiaoLcof(p1, p4);
    }

    public ListNode heBingLiangGePaiXuDeLianBiaoLcof(ListNode l1, ListNode l2) {

        // 拉链对比
        ListNode curNodeA = l1, curNodeB = l2;

        // 新链表
        ListNode newListNode = new ListNode();
        ListNode curNew = newListNode;

        while (curNodeA != null && curNodeB != null) {
            // 连接小值
            if (curNodeA.val <= curNodeB.val) {
                curNew.next = curNodeA;
                curNodeA = curNodeA.next;
            } else {
                curNew.next = curNodeB;
                curNodeB = curNodeB.next;
            }

            curNew = curNew.next;
        }

        // 连接长度差
        if (curNodeA == null) {
            curNew.next = curNodeB;
        } else {
            curNew.next = curNodeA;
        }

        return newListNode.next;
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
