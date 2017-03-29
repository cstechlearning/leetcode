/********  Binary Tree - Data Structure  ********                                           // import java.util.*; /
  traverse:

  1. BFS (Breadth First Search)  --- level order 1 - 2 -- 3 ---
  2. DFS (Depth    ~     ~)
     - preorder <root>
     - inorder         <root>
     - postorder              <root>


Algorithm Preorder(tree)
   1. Visit root.
   2. Traverse left subtree,  i.e., call Preorder(left-subtree)
   3. Traverse right subtree, i.e., call Preorder(right-subtree) 

---
Algorithm Inorder(tree)
   1. Traverse the left subtree,  i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)

---
Algorithm Postorder(tree)
   1. Traverse the left subtree,  i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.

 */

// node for tree
class Node {
	int val;
	Node left;
	Node right;

	public Node(int x) {
		val  = x;
		left = right = null;
	}
}

class Tree {
	Node root;
	Tree(){
		root = null;
	}

	void preOrder(Node r){
		if(r==null) return;
		System.out.print(r.val+" ");

		if(r.left!=null){
			// return preOrder(r.left); X 
			// return null;             X
			preOrder(r.left);
		}

		if(r.right!= null){
			preOrder(r.right);
		}
	}

	void inOrder(Node r){
		if(r==null) return;

		if(r.left!=null)
			inOrder(r.left);

		System.out.print(r.val+" ");

		if(r.right!=null)
			inOrder(r.right);
	}

	void postOrder(Node r){
		if(r==null) return;

		if(r.left!=null)
			postOrder(r.left);

		if(r.right!=null)
			postOrder(r.right);

		System.out.print(r.val+" ");
	}



	public static void main(String[] args) {
		Tree t = new Tree();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.right = new Node(3);

		System.out.println("preOrder: ");
		t.preOrder(t.root);

		System.out.println("\ninOrder: ");
		t.inOrder(t.root);

		System.out.println("\npostOrder: ");
		t.postOrder(t.root);
		
	}

}

































