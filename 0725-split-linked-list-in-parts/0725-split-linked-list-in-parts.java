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
     public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode n = head;
        int size =0;
        while(n!=null){
            size++;
            n = n.next;
        }

        int chuck = size/k;
        int remain = size%k;
        n = head;
        
        ListNode[] res = new ListNode[k];
        for(int i=0; i<k;i++){
            ListNode n1 = new ListNode();
            n1 = n;
            res[i] = n1;
            if (n!=null){
            int gap = chuck;
            if (remain>=1){
                gap++;
                remain--;
            }
            for(int j=0; j<gap-1;j++){
                n = n.next;
            }
            ListNode tmp=n;
            n=n.next;
            tmp.next = null;
            }
        }

        return res;
    }
}