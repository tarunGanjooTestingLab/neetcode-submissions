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
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = new ListNode(0);
        ListNode newHead = temp3;
        int carry = 0;

        while(temp1 != null || temp2 != null || carry != 0){
            int val1 = temp1 != null ? temp1.val : 0;
            int val2 = temp2 != null ? temp2.val : 0;
            int sum = val1 + val2 + carry;
            temp3.next = new ListNode(sum%10);
            
            carry = sum/10;

            temp3 = temp3.next;
            temp1 = temp1 != null ? temp1.next: null;
            temp2 = temp2 != null ? temp2.next: null;
        }

        return newHead.next;
    }
}
