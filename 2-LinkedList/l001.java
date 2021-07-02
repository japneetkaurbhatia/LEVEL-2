// 1st mid
public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
}

// 2nd mid
public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
}

// Reverse
public static ListNode reverse(ListNode head) {
      if(head == null || head.next == null) return head;
      ListNode curr = head;
      ListNode prev = null;
      while(curr != null) {
          ListNode forw = curr.next;
          
          curr.next = prev;
          
          prev = curr;
          curr = forw;
      }
        return prev;
}

public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
       
        ListNode mid = midNode(head);
        ListNode midList = reverse(mid.next);
        
        ListNode c1 = head;
        ListNode c2 = midList;
        boolean res = true;
        while(c2 != null){
            if(c1.val != c2.val){
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        midList = reverse(midList);
        mid.next = midList;

        return res;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        nHead = reverse(nHead);
        
        ListNode c1 = head;
        ListNode c2 = nHead;
        while(c2 != null) {
            ListNode f1 = c1.next,f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null)
            return;
            
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        
        l1.next = head;
        l2.next = head.next;
        
        ListNode p1 = l1, p2 = l2, c1 = head, c2 = head.next;
        while(c1 != null && c2 != null) {
            p1.next = c1;
            p2.next = c2;
            
            p1 = p1.next;
            p2 = p2.next;
            
            if(c2 != null)
                c1 = c2.next;
            if(c1 != null)
                c2 = c1.next;
        }
        
        p1.next = null;
        p2 = reverse(l2.next);
        p1.next = p2;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
         return l1 == null ? l2 : l1;
         
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;
        
        while(c1 != null && c2 != null) {
            if(c1.val <= c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1 != null ? c1 : c2;
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si == ei) return lists[si];
        int mid = (si + ei)/2;
        ListNode leftMergelist = mergeKLists(lists,si,mid);
        ListNode rightMergelist = mergeKLists(lists,mid+1,ei);
        return mergeTwoLists(leftMergelist,rightMergelist);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKLists(lists,0,lists.length - 1);
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        return mergeTwoLists(mergeSort(head),mergeSort(nHead));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null || n <= 0)  return head;
    
    ListNode slow = head, fast = head;
    
    while(n-- > 0) {
        fast = fast.next;
        if(fast == null && n > 0)  return head;
    }
    
    if(fast == null) {
        ListNode rNode = slow;
        head = rNode.next;
        rNode.next = null;
        return head;
    }
    
    while(fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    ListNode rNode = slow.next;
    slow.next = rNode.next;
    rNode.next = null;
    return head;
  }

  public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null)  return head;
        
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode ep = even, op = odd, curr = head;
        
        while(curr != null) {
            if(curr.val % 2 != 0) {
                op.next = curr;
                op = op.next;
            } else {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
        }
        
        ep.next = odd.next;
        op.next = null; // avoid cycle
        head = even.next;
        even.next = odd.next = null;
        return head;
    }

    public static ListNode segregate01(ListNode head) {
        if(head == null || head.next == null)  return head;
        
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode zp = zero, op = one, curr = head;
        
        while(curr != null) {
            if(curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        
        zp.next = one.next;
        op.next = null; // avoid cycle
        head = zero.next;
        one.next = zero.next = null;
        return head;
    }

    public static ListNode segregate012(ListNode head) {
       if(head == null || head.next == null)  return head;
        
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);
        ListNode zp = zero, op = one, tp = two, curr = head;
        
        while(curr != null) {
            if(curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else if(curr.val == 1){
                op.next = curr;
                op = op.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }
        op.next = two.next; // 1st
        zp.next = one.next; // 2nd
        tp.next = null;
        head = zero.next;
        one.next = zero.next = two.next = null;
        return head;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)  return head;
        
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large, curr = head;
        
        ListNode pivotNode = head;
        while(pivotNode.next != null) {
            pivotNode = pivotNode.next;
        }
        
        while(curr != null) {
            if(curr.val <= pivotNode.val) {
                sp.next = curr;
                sp = sp.next;
            } else {
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }
        
        sp.next = large.next;
        lp.next = null; // avoid cycle
        small.next = large.next = null;
        return sp;
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
       if(head == null || head.next == null)  return head;
        
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large, curr = head;
        
        ListNode pivotNode = head;
        while(pivotIdx-- > 0) {
            pivotNode = pivotNode.next;
        }
        
        while(curr != null) {
            if(curr == pivotNode){
                // continue;
            }   
            else if(curr.val <= pivotNode.val) {
                sp.next = curr;
                sp = sp.next;
            } else {
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }
        
        sp.next = pivotNode;
        pivotNode.next = large.next;
        lp.next = null; // avoid cycle
        head = small.next;
        small.next = large.next = null;
        return head;
  }