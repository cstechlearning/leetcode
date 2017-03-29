{@link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description}
// find the minimum absolute difference between values of two "any" nodes.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Solution {
    private ArrayList<Integer> vals = new ArrayList<>();
	
    public int getMinimumDifference(TreeNode root) {
    	getVals(root);
    	return getMin();
    }

    public void getVals(TreeNode root){
    	if(root==null){
    		return;
    	} else {
    		vals.add(root.val);
		
    		getVals( root.left  );
    		getVals( root.right );
    	}
    	return;
    }

    public int getMin(){
    	int[] diff = new int[vals.size()-1];
    	Collections.sort(vals);
	    
    	for(int i=0; i<vals.size()-1; i++){
    	       diff[i] =  Math.abs( vals.get(i+1) - vals.get(i) );
    	}
	    
    	Arrays.sort(diff);
    	return diff[0];

    }

}
