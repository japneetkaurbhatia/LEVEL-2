public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2, prev = dummy;
        int borrow = 0;
        while(c1 != null || c2 != null) {
            int ans = (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0) + borrow;
            if(ans < 0){
                borrow = -1;
                ans += 10;
            } else {
                borrow = 0;
            }
            prev.next = new ListNode(ans);
            prev = prev.next;
            
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        
        ListNode head = dummy.next;
        head = reverse(head);
        
        return head;
    }