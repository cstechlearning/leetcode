/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.
Example:
Given nums = [2, 7, 11, 15], target = 9, // 0 1 2 3
Because nums[0] + nums[1] = 2 + 7 = 9,   //   1 2 3    5    10
return [0, 1].*/

import java.util.*;

class Solution_O_n {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
    //    X map.add(nums[i], i); // key, entry   X Arraylist, list.add(1), but map, it's map.put(1,1)
            map.put(nums[i], i);

        for(int i=0; i<nums.length; i++){
            int j=target-nums[i];  // 7 2 -2 -6      [2] 
            if(map.containsKey(j) && j!=nums[i])  // [7]
                return new int[]{i, map.get(j)}; // 0, map.get(7)->1
        }
        throw new IllegalArgumentException("No such solution in two sum ");
    }

    public static void main(String args[]){
        Solution_O slt = new Solution_O();

        for(int x: slt.twoSum(new int[]{2,7,11,15}, 13)) 
            System.out.println(x);
    }
}

/*Time complexity: O(n)+O(1)(HashMap) = O(n)
  Space complexity : O(n)  because extra space need hashMap, length is n elements -> O(n)
*/

