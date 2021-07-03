/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode th = null, tt = null;
    public void addFirst(ListNode head) {
        if(th == null) 
            th = tt = head;
        else {
            head.next = th;
            th = head;
        }
    }
    public int length(ListNode head) {
    ListNode curr = head;
    int ctr = 0;
    while (curr != null) {
      curr = curr.next;
      ctr++;
    }
    return ctr;
  }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        int len = length(head);
        ListNode curr = head, ph = null,pt = null;
        while(curr != null && len >= k) {
            int itr = k;
            while(itr-- > 0) {
            ListNode forw = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = forw;
        }
        if(ph == null) {
            ph = th;
            pt = tt;
        } else {
            pt.next = th;
            pt = tt;
        }
        tt = null;
        th = null;
        len -= k;
    }
    pt.next = curr;
    return ph;
}
}