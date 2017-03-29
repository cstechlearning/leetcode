/********  Stack [LIFO] - Data Structure  ********                                           

  Stack is an abstruct data type or collection where in push, addition of data elements to collection, and Pop,
  removal of data elements from colletciom. are major operation performed on collection, The push and pop opertaion
  are performed only at one end of Stack which is referred to as 'top of stack'

  Stack defined as Last in Fist Out(LIFO) - data structure, i.e. 
  last element added at the top of stack(IN) should be first element to be removed(Out).*/
/*     ^
          2
          1 
          0 
 */

public class Stack {

	private int stackSize;
	private char[] stackArr;
	private int top;

	/**
	 * constructor: create stack with size
	 * @param size
	 */
	public Stack(int size){  // this: in 'this' constructor
		this.stackSize = size;
		this.stackArr = new char[stackSize];
		this.top = -1;
	}

	/** 
	 * method: add new entry to top
	 * @param entry  //will be light only when has two star
	 * @throw Exception
	 */
	public void push(char entry) throws Exception{
		if(this.isStackFull())
			throw new Exception("overflow | stack is full, can't push entry");
		System.out.println("Adding: "+entry);
		this.stackArr[++top] = entry;
	}

	/**
	 * method: remove entry from top [LIFO]
	 * @return
	 * @throw Exception
	 */
	public int pop() throws Exception{
		if(this.isStackEmpty())
			throw new Exception("underflow | stack is empty, can't pop ");
		char entry = this.stackArr[top--];
		System.out.println("Removed entry: "+entry);
		return entry; //deleted entry
	}

	public boolean isStackFull(){
		return (top == stackSize-1); // full,  top=size-1, return true
	}

	public boolean isStackEmpty(){
		return (top == -1); // empty
	}

    // return top entry of stack
	public int peek(){
		return stackArr[top];
	} 


	public static void main(String args[]){
		Stack stack = new Stack(5);

		try {
			stack.push('1');
			stack.push('2');
			stack.push('3');
			stack.push('4');
			stack.push('5');
			System.out.println("--");
			System.out.println(stack.stackArr);
			System.out.println("peek: "+stack.peek());
			System.out.println("--");
			stack.pop();
			stack.push('5');
			stack.push('6');
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}


	}

}