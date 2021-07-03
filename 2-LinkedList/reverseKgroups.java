import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
  public static ListNode th = null, tt = null;
    public static void addFirst(ListNode head) {
        if(th == null) 
            th = tt = head;
        else {
            head.next = th;
            th = head;
        }
    }
    public static int length(ListNode head) {
    ListNode curr = head;
    int ctr = 0;
    while (curr != null) {
      curr = curr.next;
      ctr++;
    }
    return ctr;
  }

  public static ListNode reverseInKGroup(ListNode head, int k) {
     if(head == null || k <= 1 ) return head;
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

public static void printList(ListNode node) {
  while (node != null) {
    System.out.print(node.val + " ");
    node = node.next;
  }
}

public static ListNode createList(int n) {
  ListNode dummy = new ListNode(-1);
  ListNode prev = dummy;
  while (n-- > 0) {
    prev.next = new ListNode(scn.nextInt());
    prev = prev.next;
  }

  return dummy.next;
}

public static void main(String[] args) {
  int n = scn.nextInt();
  ListNode h1 = createList(n);

  int k = scn.nextInt();
  h1 = reverseInKGroup(h1, k);
  printList(h1);
}
}