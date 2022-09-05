//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 自定义评测： 
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）： 
//
// 
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 
// listA - 第一个链表 
// listB - 第二个链表 
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 
// 
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内
//存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？ 
//
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 1840, 👎 0 
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
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


package editor.cn;

import java.util.ArrayList;

/**
 * Java:相交链表
 */
class IntersectionOfTwoLinkedListsCase {
    public static void main(String[] args) {
        IntersectionOfTwoLinkedListsCase runCase = new IntersectionOfTwoLinkedListsCase();

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
        System.out.println(runCase.intersectionOfTwoLinkedLists1(p1, p6));

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
        System.out.println(runCase.intersectionOfTwoLinkedLists1(p9, p14));


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
        System.out.println(runCase.intersectionOfTwoLinkedLists1(p15, p17));


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
        System.out.println(runCase.intersectionOfTwoLinkedLists1(p20, p25));
    }

    public ListNode intersectionOfTwoLinkedLists(ListNode headA, ListNode headB) {
        return null;
    }

    public ListNode intersectionOfTwoLinkedLists1(ListNode headA, ListNode headB) {
        // 我的思路, 只要给短链表补齐缺少的长度,就能保证同时遍历到相交点

        // 两个链表长度
        int listSize1 = 0, listSize2 = 0;
        ListNode curNode1 = headA, curNode2 = headB;

        while (curNode1 != null) {
            curNode1 = curNode1.next;
            listSize1++;
        }
        while (curNode2 != null) {
            curNode2 = curNode2.next;
            listSize2++;
        }

        // 补全短链表
        ArrayList<ListNode> nodeHeads = new ArrayList<>();
        if (listSize1 != listSize2) {
            for (int i = 0; i < Math.max(listSize1, listSize2) - Math.min(listSize1, listSize2); i++) {
                nodeHeads.add(new ListNode());
            }
        }
        ListNode[] nodelist = new ListNode[2];
        if (nodeHeads.size() == 0) {
            nodelist[0] = headA;
            nodelist[1] = headB;
        }
        for (int i = 0; i < nodeHeads.size(); i++) {
            if (i != nodeHeads.size() - 1) {
                nodeHeads.get(i).next = nodeHeads.get(i + 1);
            } else {
                if (listSize1 > listSize2) {
                    nodeHeads.get(i).next = headB;
                    nodelist[0] = headA;
                } else {
                    nodeHeads.get(i).next = headA;
                    nodelist[0] = headB;
                }
                nodelist[1] = nodeHeads.get(0);
            }
        }

        // 同时遍历
        ListNode curNode3 = nodelist[0], curNode4 = nodelist[1];

        while (curNode3 != curNode4) {
            curNode3 = curNode3.next;
            curNode4 = curNode4.next;
        }

        // 返回
        if (curNode3 == null) {
            return null;
        } else {
            return curNode3;
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
