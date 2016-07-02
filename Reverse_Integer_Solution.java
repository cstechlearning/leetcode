/* Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior. 
*/


import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;

public class Reverse_Integer_Solution {

    public int reverse(int x) {

        // String s_ = "111";


        String s  = Integer.toString(x);
        String result = "";

        char c[] = new char[50];
        char newc[] = new char[50];

        int neg = 0;
        int notZero = 0;


        for (int i=0; i<=s.length()-1;i++){
            c[i]= s.charAt(i);
            System.out.println(c[i]);
        }

        if (c[0]=='-'){

            neg = 1;

            for(int i=0; i<=s.length()-2; i++){
                c[i] = c[i+1];
            }
        }

        // '-' -> '+'

        if (c[0]=='0'){

            notZero = 0;

            for(int i=0; i<=s.length()-1 -neg; i++){

                notZero++;

                if (c[i]!='0') break;
            }

            for(int i=0; i<=s.length()-1 - neg - notZero; i++){

                c[i] = c[notZero];

            }

        }


        if (c[0]!='-'){

            for(int i=0; i<=s.length()-1 - neg - notZero; i++){

                newc[0 + i] = c[s.length()-1 - neg - notZero -i ];
            
            }
        }


        // result test:
        char notAdd[] = new char[50];

        for (int i =0; i<=s.length()-1; i++){
            if (newc[i]=='0'){
                notAdd[i] = '1';       
            }

            if (newc[i]!='0'){
                break;
            }
        }



        for (int i =0; i<=s.length()-1 -neg - notZero; i++){

            if (notAdd[i]!='1'){
                result += newc[i];

            }
            
        }



        if (neg ==1){
            result = '-'+ result;
        }


        System.out.println("result is ");
        System.out.println(result);

        // System.out.println(9/2);  //4 


        // char s0 = s.charAt(0);


        int answer = Integer.parseInt(result);



        return answer;
    }



    public static void main(String[] args){


        Reverse_Integer_Solution slt = new Reverse_Integer_Solution();

        try{
            number = input.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.err.println("User did not input a number. (Error Code 1)");
            System.exit(1);
        }

        System.out.println(1111111);
        System.out.println(  slt.reverse(-7800) );


    
    }


}
