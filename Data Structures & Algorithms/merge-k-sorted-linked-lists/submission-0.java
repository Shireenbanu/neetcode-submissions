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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode dummyhead = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        
        for(int index =0; index<lists.length; index++ ){
            ListNode list = lists[index];
            pq.offer(list);
            list = list.next;
            lists[index] = list;
        }

        while(pq.size()!=0){
            ListNode item = pq.poll();
            dummyhead.next = item;
            dummyhead = dummyhead.next;
            if(item.next!=null){
            pq.offer(item.next);  
            }
        }

    return head.next;
    }
}
