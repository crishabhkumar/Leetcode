/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/



//Solution:
class Solution {
    public void reorderList(ListNode head) {
        ListNode [] left =  new ListNode[1];// it will create in heap
        left[0]  =  head;
        reorder(left,head);
        
    }
    
    // left pointer will be created in heap and right pointer will be created in stack
     public void reorder(ListNode left[],ListNode right){
        if(right==null){
            return ;
        }
        reorder(left,right.next);
        
    // in post area of recursion right pointer coming back(because of function remove from recursion stack)
   // and we move left pointer forward 
        if(left[0].next!=null){
            ListNode leftNext =  left[0].next;
            left[0].next =  right;
            right.next =  leftNext;
            left[0] =  leftNext;            
        }
        
    // as we need to  merge till left pointer behind the right pointer 
        if(left[0].next == right){
            left[0].next =  null;
        }                        
    }
}
