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
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        int div = len / k;
        int mod = len % k;

        temp = head;
        ListNode prev = null;
        ListNode[] res = new ListNode[k];

        for(int i = 0; i < k && temp != null; i++, mod--){
            res[i] = temp;

            for(int j = 0; j < div + (mod > 0 ? 1 : 0); j++){
                prev = temp;
                temp = temp.next;
            }

            if(prev != null){
                prev.next = null;
            }
        }

        return res;
    }
}