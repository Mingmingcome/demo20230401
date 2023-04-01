package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @who luhaoming
 * @when 2022/5/27 22:58
 * @what 两数相加
 */
public class Q2 {
    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * <p>
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * <p>
     * 提示：
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    public static void main(String[] args) {
        ListNode l17 = new ListNode(9);
        ListNode l16 = new ListNode(9, l17);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l11 = new ListNode(9, l12);


        ListNode l24 = new ListNode(9);
        ListNode l23 = new ListNode(9, l24);
        ListNode l22 = new ListNode(9, l23);
        ListNode l21 = new ListNode(9, l22);

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);

        ListNode listNode = addTwoNumbers1(l21, l11);
        if (listNode == null) {
            return;
        }
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 求和，满10进位
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + sum / 10;
                list.add(sum % 10);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + sum / 10;
                list.add(sum % 10);
                l1 = l1.next;
            } else {
                sum = l2.val + sum / 10;
                list.add(sum % 10);
                l2 = l2.next;
            }
        }
        // 最后一位
        if (sum >= 10) {
            list.add(sum / 10);
        }
        // 组装链表
        ListNode tail = new ListNode(list.get(list.size() - 1));
        ListNode head = tail;
        for (int i = list.size() - 2; i >= 0; i--) {
            head = new ListNode(list.get(i), tail);
            tail = head;
        }


        return head;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 求和，满10进位
        ListNode tmpL1 = l1;
        ListNode tmpL2 = l2;
        int len = 0;
        while (tmpL1 != null || tmpL2 != null) {
            len++;
            tmpL1 = tmpL1 == null ? null : tmpL1.next;
            tmpL2 = tmpL2 == null ? null : tmpL2.next;
        }
        int[] list = new int[len + 1];
        int sum = 0, index = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + sum / 10;
                list[index] = sum % 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + sum / 10;
                list[index] = sum % 10;
                l1 = l1.next;
            } else {
                sum = l2.val + sum / 10;
                list[index] = sum % 10;
                l2 = l2.next;
            }
            index = index + 1;
        }
        if (sum >= 10) {
            list[len] = sum / 10;
        } else {
            len = len - 1;
        }
        // 组装链表
        ListNode tail = new ListNode(list[len]);
        ListNode head = tail;
        for (int i = len - 1; i >= 0; i--) {
            head = new ListNode(list[i], tail);
            tail = head;
        }


        return head;
    }


}

class ListNode {
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
