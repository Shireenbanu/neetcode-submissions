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
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null){
          ListNode temp = curr;
          curr = curr.next;
        //   if(curr!=null){
        //   next =curr.next;}
        //   else{
        //   next = null;

          if(curr!=null){
          next =curr.next;
          temp.next = prev;
          curr.next = temp; 
          prev = curr;
          curr = next;
          }
          else
          {
            temp.next=prev;
            prev = temp;
            next = null;
          }
        }
        

   return prev;
    }
}
