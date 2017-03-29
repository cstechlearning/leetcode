// find the minimum absolute difference between values of two "adjacent" nodes.

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

public class Solution {
    private ArrayList<Integer> diff = new ArrayList<>();
	
	public int getMinimumDifference(TreeNode root) {
		// pre
		if(root==null)   // null, it will return, so no worry getMini() needs if(r.left=!null)
			return Collections.min( diff );		
		else{
			if(root.left!=null){
				diff.add( Math.abs(root.val - root.left.val) );
			}

			if(root.right!=null){
				diff.add( Math.abs(root.val - root.right.val) );
			}

			getMinimumDifference( root.left );
			getMinimumDifference( root.right );
		}
		
		return Collections.min( diff );
			
	}
}
