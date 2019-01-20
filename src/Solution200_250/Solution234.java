package Solution200_250;
import BasicDataStructure.*;
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode cur = head, first = new ListNode(0);
        first.next = head;
        while(cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            head = head.next;
        }
        ListNode secondhead = reverse(head.next);
        while (secondhead != null) {
            if (first.next.val != secondhead.val) {
                return false;
            }
            secondhead = secondhead.next;
            first = first.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode root = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}
