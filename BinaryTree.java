/* Implement Binary Tree (Data Structure) */
/* Collection is also a implementation by java default package */

class BTNode{

  BTNode left, right;
  int data;

  /* constructor */
  public BTNode(){
    left  = null;
    right = null;
    data  = 0;
  }

  /* constructor 2 */
  public BTNode(int n){
    left  = null;
    right = null;
    data  = n;
  }

  public void   setLeft(BTNode node) { left  = node; }
  public void   setRight(BTNode node){ right = node; }
  public BTNode getLeft()            { return  left; }
  public BTNode getRight()           { return  right;}
  public void   setData(int val)     { data  = val;  }
  public int    getData()            { return  data; }

}

/* BT using recursion */
class BT{

  private BTNode root;
  public  BT(){  root = null; } // constuctor

  public boolean isEmpty(){ return root == null; }

  // insert recursively
  public void insert(int data){
    root = insert(root, data);
    System.out.println("inserted. "+data);

  }

  private BTNode insert(BTNode node, int data){
    if(node == null)
      node = new BTNode(data);
    else{
      if(node.getRight()==null)
        node.right = insert(node.right, data);
      else
        node.left  = insert(node.left, data);
    }
    return node;
  }


  // count recursively
  public int countNodes(){
    return countNodes(root);
  }

  private int countNodes(BTNode root){ //root
    if(root == null)
      return 0;
    else{
      int l = 1; //leaf
      l+= countNodes(root.getLeft());
      l+= countNodes(root.getRight());
      return l;
    }
  }


  // search recursively
  public boolean search(int val){
    return search(root, val);
  }
  private boolean search(BTNode root, int val){
    if(root.getData()==val)
      return true;

    if(root.getLeft()!=null)
      if(search(root.getLeft(), val))
        return true; // search until 'left==null', out
  
    if(root.getRight()!=null)
      if(search(root.getRight(), val))
        return true;
  
    return false;
  }

//   Breath-First (Search)  广度优先 - BFS
// -> Level-order

// Depth-First (Search) 深度优先 - DFS
// -> Preorder   <root><left><right>
// -> Inorder    <left><root><right>
// -> Postorder  <left><right><root>

  // preorder traverse   <root><left><right>
  public void preorder(){
    preorder(root);
  }

  private void preorder(BTNode r){ // root
    if(r!=null){
      System.out.print(r.getData()+" -> ");
      preorder(r.getLeft());
      preorder(r.getRight());
    } else {
      // System.out.println("null");
    }
  }

  //postorder traverse  <left><right><root>
  public void postorder(){
    postorder(root);
  }

  private void postorder(BTNode r){
    if(r!=null){
      postorder(r.getLeft());
      postorder(r.getRight());
      System.out.print(r.getData()+" -> ");
    } else {
      // System.out.println("null");
    }
  }

  //inorder traverse  <left><root><right>
  public void inorder(){
    inorder(root);
  }
  private void inorder(BTNode r){
    if(r!=null){
      inorder(r.getLeft());
      System.out.print(r.getData()+" -> ");
      inorder(r.getRight());
    } else {
      // System.out.println("null");
    }
  }

}


public class BinaryTree{

  static BT bt = new BT();

  public static void run(int i, String[] arr){
    switch(i){
      case 1:
         System.out.println("now, inserting: ");
         for(String x: arr)
            bt.insert( Integer.parseInt(x));
         break;
      case 2: 
         System.out.println("now, searching: "+ Integer.parseInt(arr[0]));
         System.out.println("Result = "+  bt.search(Integer.parseInt(arr[0])) );
        
         break;
      case 3:
         System.out.println("Nodes = "+ bt.countNodes());
         break;
      case 4:
         System.out.println("Empty = "+bt.isEmpty());
         break;
      case 5:
         System.out.println("Preorder = ");
         bt.preorder();
         System.out.println();
         break;
      case 6:
         System.out.println("Postorder = ");
         bt.postorder();
         System.out.println();
         break;
      case 7:
         System.out.println("Inorder = ");
         bt.inorder();
         System.out.println();
         break;
      default:
        System.out.println("Wrong number = "+i+". (not 1-4)");
        break;
    }

    System.out.println("˚");//ˆ

  }


  public static void main(String[] args) throws Exception{

    System.out.println("| This is ---- Binary Tree ---- Data Structure |\n");
    // try{
    //   java.io.PrintWriter pw = new java.io.PrintWriter("input.txt");
    //   pw.println("- Binary Tree Operations: \n");
    //   pw.println("- 1. insert ");
    //   pw.println("- 2. search");
    //   pw.println("- 3. count nodes");
    //   pw.println("- 4. check empty");
    //   pw.println("- 5. preorder  traverse   <'root'>  <left>  <right>");
    //   pw.println("- 6. postorder traverse   <left>   <right>  <'root'>");
    //   pw.println("- 7. inorder   traverse   <left>   <'root'> <right>");
    //   pw.close();
    // } catch(Exception e){
    //   System.out.println(e.getLocalizedMessage());                       // ur own language, e.g. Chinese (if Override)
    // }

    java.io.File    file    = new java.io.File("input.txt");
    java.util.Scanner input = new java.util.Scanner(file);

    // while(input.hasNextLine())
    //   System.out.println(input.nextLine());

    while(input.hasNextLine()){

      if(input.nextLine().indexOf("start")!= -1){

        while(input.hasNextLine()){

          int i = Integer.parseInt(input.nextLine());
          if(i<3){          
            String s = input.nextLine();
            // System.out.println(s);  10 20 30 40 \n 30 \n 90
            run(i, s.split("\\s+"));

          } else {
            run(i, new String[]{});
          }

          if(input.hasNextLine()) 
            input.nextLine();    //eat empty line
        }


      }

  
    }

    // System.out.println( Integer.parseInt("1"));    
  }
}


/* ------  OUTPUT ---------

| This is ---- Binary Tree ---- Data Structure |

Empty = true
˚
now, inserting: 
inserted. 10
inserted. 20
inserted. 30
inserted. 40
inserted. 50
inserted. 60
˚
now, inserting: 
inserted. 70
inserted. 80
˚
now, searching: 90
Result = false
˚
now, searching: 80
Result = true
˚
now, inserting: 
inserted. 90
inserted. 100
˚
Nodes = 10
˚
Empty = false
˚
now, searching: 100
Result = true
˚
Preorder = 
10 -> 30 -> 50 -> 70 -> 90 -> 100 -> 80 -> 60 -> 40 -> 20 -> 
˚
Postorder = 
100 -> 90 -> 80 -> 70 -> 60 -> 50 -> 40 -> 30 -> 20 -> 10 -> 
˚
Inorder = 
90 -> 100 -> 70 -> 80 -> 50 -> 60 -> 30 -> 40 -> 10 -> 20 -> 
˚
[Finished in 1.4s]









*/




