class Node<T> implements Comparable<T> {

	private T value;                         //T -> Type
	private Node<T> nextRef;

	public T getValue(){
		return value;
	}
	public void setValue(T value){
		this.value = value;
	}
	public Node<T> getNextRef(){   // <-
		return nextRef;
	}
	public void setNextRef(Node<T> ref){
		this.nextRef = ref;
	}
	@Override
	public int compareTo(T arg){
		return (arg==this.value)? 0 : 1 /* @Override compareTo get 0 means same */
	}

}

public class SinglyLinkedList<T> {

	private Node<T> head; //a T type variable to store head of list
	private Node<T> tail;
	// private ArrayList<T> al;
	// T = {int, double, float.. }


	public void add(T new_value){
		Node<T> nd = new Node<T>();
		nd.setValue(new_value);
		System.out.println("Adding: "+new_value);

		if(head == null){
			head = nd;
			tail = nd;
		}else{
			//set current tail -> new node
			tail.setNextRef(nd);
			//set tail as newly created one
			tail = nd;
		}
	}

	public void addAfter(T new_value, T after_value){
		Node<T> temp = head;
		Node<T> refNode = null;    //refNode: head 1 2 3 .. [54] 55
		System.out.println("Traverse to all nodes...");
		/*
		 * Traverse till given element
		 */
		while(true){
			if(temp == null)
				break;
			if(temp.compareTo(after_value)==0){
				//found target node, add after this node
				refNode = temp;
				break;
			}
			temp = temp.getNextRef();
		}
		if(refNode!= null){
			Node<T> nd = new Node<T>();
			nd.setValue(new_value);
			nd.setNextRef(temp.getNextRef());
			if(temp == tail)
				tail = nd;
			temp.setNextRef(nd);
		}else{
			System.out.println("Unable to find this given after_value " + after_value);
		}
	}

	public void deleteFront(){
		if(head == null)
			System.out.println("Underflow...");
		Node<T> temp = head;
		head = temp.getNextRef();
		if(head == null)
			tail = null;
		System.out.println("Deleted: "+ temp.getValue());
	}

	public void deleteAfter(T after_value){
		Node<T> temp = head;
		Node<T> refNode = null;
		System.out.println("Traverse to all nodes...");
		/*
		 * Traverse till given element
		 */
		while(true){
			if(temp == null)
				break;
			if(temp.compareTo(after_value)==0){
				refNode = temp;
				break;
			}
			temp = temp.getNextRef();
		}
		if(refNode!=null){
			temp = refNode.getNextRef();
			refNode.setNextRef(temp.getNextRef());
			if(refNode.getNextRef()==null)
				tail = refNode;
			System.out.println("Deleted: "+temp.getValue());
		} else {
			System.out.println("Unable to find this given after_value " + after_value);
		}
	}

	public void traverse(){  //遍历
		Node<T> temp = head;
		while(true){
			if(temp == null)
				break;
			System.out.println("Node: <T> "+temp.getValue());
			temp = temp.getNextRef();	
		}
	}


	public static void main(String args[]){


/*		java:90: error: non-static type variable T cannot be referenced from a static context
	 X	SinglyLinkedList<T> s1 = new SinglyLinkedList<T>();                                   */
		
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		sl.addAfter(76, 54);
		sl.deleteFront();
		sl.deleteAfter(76);
		sl.traverse();


	}
}




	//reverse: 反转
	//traverse: 遍历




