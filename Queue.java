/********  Queue - Data Structure  ********                                          

  Queue is an abstruct data type, first add first remove, last add last remove 
 (Stack first add last remove)

 enqueue: add item on end        123 +
 front: return item at front    ^123
 dequeue: remove item at first  -123

 overflow:  full++
 underflow: empty-- 

 add/delete O(1)       
 -- */

public class Queue {

	private int capacity;
	int queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;

	public Queue(int queueSize){
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
	}

	/**
	 * add item at end
	 * @param item
	 */
	public void enqueue(int item){ //[]++
		if(isQueueFull())
			System.out.println("oveflow! queue full");
		else{
			rear++;
			if(rear == capacity-1) // full
				rear = 0;
			queueArr[rear] = item;
			currentSize++;
			System.out.println("Element "+ item + " enqueued!");
		}
	}

	/**
	 * remove at first
	 */
	public void dequeue(){ // --[]
		if(isQueueEmpty())
			System.out.println("underflow! queue empty");
		else{
			front++;

			System.out.println("Pop operation done ! Element "+ queueArr[front-1] + " has been dequeued!");
			if(front == capacity-1) // -> null
				front = 0;
		}
		currentSize--;

	}

	public boolean isQueueFull(){
		return currentSize == capacity ? true : false;
	}

	public boolean isQueueEmpty(){
		return currentSize == 0 ? true : false;
	}

	public static void main(String[] args) {

		Queue qu = new Queue(4);
		qu.enqueue(4);
        qu.dequeue();

        qu.enqueue(56);
        qu.enqueue(2);
        qu.enqueue(67);

        qu.dequeue();
        qu.dequeue();

        qu.enqueue(24);
        qu.dequeue();

        qu.enqueue(98);
        qu.enqueue(45);
        qu.enqueue(23);
        qu.enqueue(435);

		
	}
 
}

/*  --------------- OUTPUT ---------------

Element 4 enqueued!
Pop operation done ! Element 4 has been dequeued!
Element 56 enqueued!
Element 2 enqueued!
Element 67 enqueued!
Pop operation done ! Element 56 has been dequeued!
Pop operation done ! Element 2 has been dequeued!
Element 24 enqueued!
Pop operation done ! Element 67 has been dequeued!
Element 98 enqueued!
Element 45 enqueued!
Element 23 enqueued!
oveflow! queue full
[Finished in 1.5s]