package work.kaiyu.datastructure.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import work.kaiyu.datastructure.leetcode.链表.ListNode;
import work.kaiyu.datastructure.leetcode.链表._203_移除链表元素;

@Slf4j
public class Solve {
    @Test
    public void solve() {
        ListNode head = new ListNode(5, new ListNode(1, new ListNode(3, new ListNode(4))));
        ListNode listNode = _203_移除链表元素.removeElements(head, 4);
        log.info("listNode:{}", listNode);
    }
}
