package work.kaiyu.datastructure.leetcode;

import work.kaiyu.datastructure.leetcode.链表.ListNode;

/**
 * @author: hamster
 * @date: 2021/1/20 16:37
 * @description:
 * @url: https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {

        ListNode[] A = new ListNode[100];

        int t = 0;

        while (head != null) {
            A[t++] = head;
            head = head.next;
        }

        return A[t / 2];
    }
}
