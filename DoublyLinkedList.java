/********  DoublyLinkedList - Data Structure ******** */

import java.util.NoSuchElementException;

public class DoublyLinkedList<E>{
	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList(){  // default constructor
		size = 0;
	}

	/**
	 * this inner class keeps track of each element info
	 * @author java2novice
	 */
	private class Node {
		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev){
			this.element = element; // class inner this.element <- para
			this.next = next;
			this.prev = prev;
		}

	}

	/**
	 * return size of linked-list
	 * @return
	 */
	public int size(){ return size;}

	/**
	 * return whether list is empty or not
	 * @return
	 */
	public boolean isEmpty(){    // X public boolean isEmpty{} 这是个function 不是构造类
		return size==0 ; 
	}

	/**
	 * add element at starting of linked list
	 * @param element
	 */
	public void addFirst(E element){
		Node temp = new Node(element, head, null);
		if(head!=null)
			head.prev = temp;
		head = temp;
		if(head==null)
			tail = temp;
		size++;
		System.out.println("adding: "+element);
	}

	public E removeFirst(){
		if(size==0)
			throw new NoSuchElementException();
		Node temp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleting: "+temp.element);
		return temp.element;
	}

	public void iterateForward(){
		System.out.println("iterate forward now..");
		Node temp = head;
		while(temp!=null){
			System.out.println("Now: "+temp.element);
			temp = temp.next;
		}
	}



	public static void main(String a[]){
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		dll.addFirst("第一个值 I");
		dll.addFirst("第二个值 II");
		dll.addFirst("第三个值 III");
		dll.iterateForward();



	}
}


/* generic class: type parameter should be followed by class name, and contain in <>,  T: type    
   here T is type parameter, will be replaced by actual type when object creates             */    