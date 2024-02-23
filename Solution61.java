/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-22 20:03:22
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-22 20:03:25
 * @FilePath: \Java-LeetCode\Solution61.java
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        // add的值代表cur接下来要走几步，其实是走到新头节点的上一个的节点，所以上一个节点的next指针指向的就是新头节点
        int add = length - (k % length);
        cur.next = head;
        while (add -- > 0) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
