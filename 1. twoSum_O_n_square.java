/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.
Example:
Given nums = [2, 7, 11, 15], target = 9, // 0 1 2 3
Because nums[0] + nums[1] = 2 + 7 = 9,   //   1 2 3
return [0, 1].*/

class Solution_O_n_square {

    public int[] twoSum(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No such solution in two sum! ");
        // return new int[]{-1};
    }

    public static void main(String args[]){
        Solution_O_n_square slt = new Solution_O_n_square();

        for(int x: slt.twoSum(new int[]{2,7,11,15}, 20)) 
            System.out.println(x);
    }
}

/* Time complexity:   O(n^2)
   Space complexity : O(1)  because no extra space need 
*/

