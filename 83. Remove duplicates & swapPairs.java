/**
 * Definition for singly-linked list. **/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

//       head
// h X -> 1 -> 2 -> 3 -> 4
// h X  -----> 2 -> 3 -> 4
// h X  -----> 2 -> ||| 1 -> 2 -> 3 -> 4 X


public class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head!=null && head.next!=null){
            // ListNode temp = head.next;
            // head.next = head.next.next;
            // head.next.next = temp;
            int temp = head.next.val;
            head.next.val = head.val;
            head.val = temp;
            swapPairs(head.next.next);
    
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) { // 1 1 2
        //                                                 ^

        ListNode res = head;

        while(head!=null && head.next!=null){

            while(head.next!=null  &&  head.val==head.next.val){
                System.out.println("Yes");
                head.next = head.next.next;
            }
            head = head.next;
        }

        return res;
    }



    public ListNode deleteDuplicates2(ListNode head) { // 1 1 2
        //                                                 ^
        ListNode res = head;

        while(res!=null && res.next!=null){

            while(res.next!=null  &&  res.val==res.next.val){
                System.out.println("Yes");
                res.next = res.next.next;
            }
            res = res.next;
        }
        return head;
    }

    /** official way */

    public ListNode deleteDuplicates3(ListNode head){
        ListNode cur = head;  // cur取得了head的地址，对cur修改，便是对head修改
        while(cur!=null && cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
    
    /*
    Time Complexity:
    
    Cuz each node in list is checked exactly once 
    to determine 
    if it is a duplicate, 
    so 
    total run time is O(n), where n is the number of nodes in the list.

    Space complexity is 
    O(1) 
    since no additional space is used.
    
    O(1)的意思就是与n无关;
    ListNode cur = head; // 这一步只是cur获取了head的地址，对cur修改，便是对head修改。跟这个list有多长跟n是无关的！
    
    */








    public void print(ListNode r){
        if(r!=null){
            System.out.print(r.val+" ");
            print(r.next);
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(6);
        Solution slt = new Solution();
        slt.print(l1);  
        System.out.println();

        // slt.print(  slt.swapPairs(l1)  );
        slt.print(  slt.deleteDuplicates(l1) );
        System.out.println("|||");
        slt.print(  slt.deleteDuplicates2(l1) );

        System.out.println("||| OFFICIAL SOL");
        slt.print(  slt.deleteDuplicates3(l1) );





    }
}