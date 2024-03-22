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
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode current = head;
        while(current!=null)
        {
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode second = reverse(slow.next);
        
        ListNode first = head;
        
        while(first!=null && second!=null)
        {
            if(first.val != second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
        
    }
}