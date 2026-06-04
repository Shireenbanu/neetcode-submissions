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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                dummyHead.next = ptr1;
                ptr1 = ptr1.next;
                // System.out.println("Now ptr1 is pointing to: "+ ptr1.val);

            } else {
                dummyHead.next = ptr2;
                ptr2 = ptr2.next;
                // System.out.println("Now ptr2 is pointing to: "+ ptr2.val);
            }
            dummyHead = dummyHead.next;

        }

        while(ptr1!=null){
          dummyHead.next = ptr1;
          ptr1 = ptr1.next;
          dummyHead = dummyHead.next;

        }

         while(ptr2!=null){
          dummyHead.next = ptr2;
          ptr2 = ptr2.next;
          dummyHead = dummyHead.next;
        }

        dummyHead.next = null;

        // while (head != null) {
        //     System.out.println(head.val);
        //     head = head.next;
        // }

        return head.next;
    }
}