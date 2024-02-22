class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end.equals(null)) {
                break;
            }
            ListNode tail = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = tail;
            pre = start; // 尾巴
            end = pre; 
        }
        return dummy.next;
    }
    /**
     * 翻转链表核心思想就是将每个节点的next指针指向前一个节点, 所以pre一开始是null
     * @param head 起始节点
     * @return 返回的是最后一个节点
     */
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}