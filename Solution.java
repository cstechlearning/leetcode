import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int _i=0;
        int f=0;
        int a=0, b=0;
        int hasZeroItem = 0;

         for(int i=0; i<=len-1; i++){
            if(nums[i]==0)
                hasZeroItem++;
         }
           

        if(target==0 && hasZeroItem>=2){
            System.out.println("Special overflow 0");
             for(int i=0; i<=len-1; i++){
                if(nums[i]==0){
                    b=i;
                    continue;
                }

                if(nums[i]==0){
                     a=i;
                     break;
                }

             }

        } 
        else {


        for(int i=0; i<=len-1; i++){
            System.out.println("normal case");
            System.out.println(a);
            System.out.println(b);



            for(int n=_i+1;n<=len-1;n++){
                
                if(_i==n) continue;
            
                if(nums[_i]+nums[n]==target){
                    System.out.println("now ==");
                    a = _i;
                    b = n;
                    f = 1;
                    break;   
                }
            }

            if(f!=0)
                break;


            _i++;   //otherwise,   +1   +1  
        }



        }

        int result[] = new int[2];
        result[0] = a;
        result[1] = b;
        return result; //   return slt.twoSum([2,7,11,15], 9)  ->  [0,1] 
    }


    public static void main(String[] args){
        Solution slt = new Solution();

        int numbers[]={-3,4,3,90};
        int target = 0;
        int answer[] = new int[2]; 
        answer = slt.twoSum(numbers, target);
        
        System.out.println(Arrays.toString(answer));
    }


}