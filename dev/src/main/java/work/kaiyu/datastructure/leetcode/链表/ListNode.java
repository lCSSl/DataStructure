package work.kaiyu.datastructure.leetcode.链表;

import lombok.ToString;

/**
 * @author: hamster
 * @date: 2021/1/20 14:37
 * @description:
 * @url:
 */
@ToString
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
