/* 598. Range Addition II

Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input: 
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation: 
Initially, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4. */


public class Solution {
    /*
    public int maxCount(int m, int n, int[][] ops) {

        if(ops==null) return 0;

        // int[] s = new int[2]; // small
        int[] s = ops[0];
        // int res = oops.length;

        for(int[] x: ops){

            if(s[0] <= x[0]  &&  s[1] <= x[1] ){
                // s 
            } else if(x[0]< s[0]  &&  x[1] < s[1] ){
                s = x;
            } else {

                s[0] = Math.min( s[0], x[0]);
                s[1] = Math.min( s[1], x[1]);

            }

        }

        return s[0] * s[1];

        // time:  O(n), n is number of ops
        // space: O(2?), constant space new int[2];        
    }
    */

    // can you do it without extra space? O(1) - no extra space?
    public int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length<1) return m*n;
        for(int[] x: ops){
            m = Math.min(m, x[0]);
            n = Math.min(n, x[1]);
        }

        return m*n;
    }

        // time:  O(n), n is number of ops
        // space: O(1), no extra space. Nice!





    public static void main(String[] args) {

        Solution slt = new Solution();
        System.out.println(

            slt.maxCount(3, 3, null)

        );
        
    }
}










// import java.util.HashMap;
// import java.util.ArrayList;

// public class Solution {
//     public String[] findRestaurant(String[] list1, String[] list2) {

//         ArrayList<String> res = new ArrayList<>();
//         int idx = Integer.MAX_VALUE;


//         HashMap<String, Integer> hm = new HashMap<>();
//         for(int i=0; i<list1.length; i++){
//             hm.put(list1[i], i);
//         }

//         for(int i=0; i<list2.length; i++){
//             if(hm.containsKey(list2[i])  ) {

//                 if( (hm.get(list2[i]) + i) < idx  ){
//                     res.clear();
//                     res.add(list2[i]);
//                     idx = (hm.get(list2[i]) + i);

//                 } else if( (hm.get(list2[i]) + i) == idx  ){
//                     res.add(list2[i]);
//                 }
//             }
//         }


//         String[] ans = new String[res.size()];

//         for(int i=0; i<res.size(); i++){
//             ans[i] = res.get(i);
//         }




//         return ans;
        
//     }

//     public static void main(String[] args) {
//         String[] l1 = new String[]{  "Shogun", "Tapioca Express", "Burger King", "KFC" };
//         String[] l2 = new String[]{  "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

//         Solution slt = new Solution();

//         String[] ans = slt.findRestaurant(l1, l2);


        
//     }
// }