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
    public void addFirstNode(ListNode head) {
        if(th == null) 
            th = tt = head;
        else {
            head.next = th;
            th = head;
        }
    }
    public ListNode reverseInRange(ListNode head, int n, int m) {
        if(head.next == null || m == n)
            return head;
        int i = 1;
        ListNode curr = head, prev = null;
        while(curr != null) {
            while(i >= n && i <= m) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }
            if(i > m) {
                if(prev == null) {
                    tt.next = curr;
                    return th;
                } else {
                    prev.next = th;
                    tt.next = curr;
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return null;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseInRange(head,left,right);
    }
}