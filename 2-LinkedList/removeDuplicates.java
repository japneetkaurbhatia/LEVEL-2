public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head, curr = head.next;
        while(curr != null) {
            while(curr != null && curr.val == prev.val) {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            prev.next = curr;
            prev = prev.next;
            if(curr != null)
                curr = curr.next;
        }
        return head;
    }