//输入两个链表，找出它们的第一个公共节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
//skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-
//lists/
//
//
// Related Topics哈希表 | 链表 | 双指针
//
// 👍 549, 👎 0
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
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
//class Solution {
//    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

/**
 * Java:两个链表的第一个公共节点
 */
class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcofCase {
    public static void main(String[] args) {
        LiangGeLianBiaoDeDiYiGeGongGongJieDianLcofCase runCase = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcofCase();


        // case1
        // 输入：输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 输出：Intersected at '8'
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(8);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode p6 = new ListNode(5);
        ListNode p7 = new ListNode(6);
        ListNode p8 = new ListNode(1);
        p6.next = p7;
        p7.next = p8;
        p8.next = p3;
        System.out.println(runCase.liangGeLianBiaoDeDiYiGeGongGongJieDianLcof(p1, p6));

        // case2
        // 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Intersected at '2'
        ListNode p9 = new ListNode(1);
        ListNode p10 = new ListNode(9);
        ListNode p11 = new ListNode(1);
        ListNode p12 = new ListNode(2);
        ListNode p13 = new ListNode(4);
        p9.next = p10;
        p10.next = p11;
        p11.next = p12;
        p12.next = p13;
        ListNode p14 = new ListNode(3);
        p14.next = p12;
        System.out.println(runCase.liangGeLianBiaoDeDiYiGeGongGongJieDianLcof(p9, p14));


        // case3
        // 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null
        ListNode p15 = new ListNode(1);
        ListNode p16 = new ListNode(5);
        p15.next = p16;
        ListNode p17 = new ListNode(2);
        ListNode p18 = new ListNode(6);
        ListNode p19 = new ListNode(4);
        p17.next = p18;
        p18.next = p19;
        System.out.println(runCase.liangGeLianBiaoDeDiYiGeGongGongJieDianLcof(p15, p17));


        // case4
        // 输入：intersectVal = 4, listA = [2,2,4,5,4], listB = [2,2,4,5,4] skipA = 2, skipB = 2 Intersected at '2'
        ListNode p20 = new ListNode(2);
        ListNode p21 = new ListNode(2);
        ListNode p22 = new ListNode(4);
        ListNode p23 = new ListNode(5);
        ListNode p24 = new ListNode(4);
        p20.next = p21;
        p21.next = p22;
        p22.next = p23;
        p23.next = p24;
        ListNode p25 = new ListNode(2);
        ListNode p26 = new ListNode(2);
        p25.next = p26;
        p26.next = p22;
        System.out.println(runCase.liangGeLianBiaoDeDiYiGeGongGongJieDianLcof(p20, p25));
    }

    public ListNode liangGeLianBiaoDeDiYiGeGongGongJieDianLcof(ListNode headA, ListNode headB) {

        // 长度差
        int aSize = 0, bSize = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            curA = curA.next;
            aSize++;
        }
        while (curB != null) {
            curB = curB.next;
            bSize++;
        }
        int gapSize = Math.abs(aSize - bSize);

        // 补齐短链
        if (gapSize > 0) {
            ListNode newHead = new ListNode(), newCur = newHead;
            for (int i = 0; i < gapSize - 1; i++) {
                newCur.next = new ListNode();
                newCur = newCur.next;
            }
            newCur.next = aSize >= bSize ? headB : headA;
            curA = aSize > bSize ? headA : newHead;
            curB = aSize < bSize ? headB : newHead;
        } else {
            curA = headA;
            curB = headB;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        if (curA != null) return curA;
        else return null;

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
