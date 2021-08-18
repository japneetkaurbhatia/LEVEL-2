public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode curr = head, prev = null;
        while(curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2, prev = dummy;
        int carry = 0;
        while(carry != 0 || c1 != null || c2 != null) {
            int sum = (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0) + carry;
            carry = sum/10;
            sum %= 10;
            prev.next = new ListNode(sum);
            prev = prev.next;
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        ListNode head = dummy.next;
        head = reverse(head);
        l1 = reverse(l1);
        l2 = reverse(l2);
        return head;
    }