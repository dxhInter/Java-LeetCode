/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-27 20:30:32
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-27 20:55:01
 */
public class Solution206 {
    /**
     * 迭代
     * 时间复杂度：O(n), 其中 n 是链表的长度。需要遍历链表一次。空间复杂度：O(1)。
     * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
     * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归的方法
     * 若从节点 nk+1 到 nm 已经被反转，而我们正处于 nk
     * 我们希望 nk+1 的下一个节点指向 nk
     * 需要注意的是 n1的下一个节点必须指向 null。如果忽略了这一点，链表中可能会产生环。
     * @param head
     * @return
     */
    public ListNode reverseListWithHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListWithHead(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}