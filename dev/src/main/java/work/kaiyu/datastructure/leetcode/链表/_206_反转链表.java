package work.kaiyu.datastructure.leetcode.链表;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: hamster
 * @date: 2021/1/20 14:33
 * @description:
 * @url: https://leetcode-cn.com/problems/reverse-linked-list/
 */
@Slf4j
public class _206_反转链表 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
