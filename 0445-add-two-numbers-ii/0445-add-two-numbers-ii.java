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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode t1 = l1;
        ListNode t2 = l2;

        while(t1 != null){
            s1.push(t1.val);
            t1 = t1.next;
        }

        while(t2 != null){
            s2.push(t2.val);
            t2 = t2.next;
        }

        LinkedList<Integer> ans = new LinkedList<>();
        int carry = 0;
        while(s1.size() > 0 && s2.size() > 0){
            int n1 = s1.pop();
            int n2 = s2.pop();
            int sum = n1 + n2 + carry;
            if(sum > 9){
                ans.addFirst(sum % 10);
                carry = sum/10;
            }else{
                ans.addFirst(sum);
                carry = 0;
            }
        }

        while(s1.size()>0){
            int sum = carry + s1.pop();
            if(sum > 9){
                carry = sum/10;
                ans.addFirst(sum%10);
            }else{
                ans.addFirst(sum);
                carry = 0;
            }
        }

        while(s2.size()>0){
            int sum = carry + s2.pop();
            if(sum > 9){
                carry = sum/10;
                ans.addFirst(sum%10);
            }else{
                ans.addFirst(sum);
                carry = 0;
            }
        }


        while(carry > 0){
            ans.addFirst(carry % 10);
            carry = carry/10;
        }

        ListNode head = null;
        ListNode temp = null;
        for(int n : ans){
            if(head == null){
                head = new ListNode(n);
                temp = head;
            }else{
                temp.next = new ListNode(n);
                temp = temp.next;
            }
        }

        return head;

    }
}