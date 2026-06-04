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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isOdd = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the first half:
        if (fast != null) 
            isOdd = true;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != slow) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }

        ListNode firstSet = prev;
        ListNode secondSet = slow;
        ListNode swapHead = secondSet;

        if (isOdd) {
            secondSet = secondSet.next;
        }

        while (firstSet != null && secondSet != null) {
            ListNode temp = secondSet.next;
            ListNode swap = firstSet;

            secondSet.next = firstSet;
            firstSet = firstSet.next;
            swap.next = temp;
            secondSet = temp;
        }

        ListNode curr1 = swapHead;
        ListNode p = null;

        while (curr1 != null) {
            ListNode temp = curr1;
            curr1 = curr1.next;
            temp.next = p;
            p = temp;
        }

    }
}
