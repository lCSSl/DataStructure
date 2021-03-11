package work.kaiyu.datastructure.leetcode;


import work.kaiyu.datastructure.leetcode.链表.ListNode;

/**
 * @author: hamster
 * @date: 2021/1/20 14:23
 * @description:
 * @url: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        System.gc();
    }
}
