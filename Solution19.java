/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-21 20:04:13
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-21 20:33:03
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy.next; //设置fast的位置为链表头部
        ListNode slow = dummy;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode nodeByDeleted = slow.next;
        slow.next = nodeByDeleted.next;
        return dummy.next;
    }
}
