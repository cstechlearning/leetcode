/* PQ is an ADT, abstruct data type
   like queue/stack
   but each element has a "priority" with it
   high prioirty served before low ~

   worst case: (upper bound)
   insert: O(1)
   search: O(n)
 */

 public class PriorityQueue {
 	private Comparable[] pQueue;
 	private int index;  // current idx
 	private int size;

 	public PriorityQueue(int capacity){    // constructor
 		pQueue = new Comparable[capacity];
 		size = capacity;
 	}


 	public void insert(Comparable item){
 		if(index == size){
 			System.out.println("PriorityQueue full, can't add");
 			return;
 		}

 		pQueue[index] = item; // 0 1 2 3 4 [5]
 		index++;              //   1 2 3 4 5

 		System.out.println(item + " added");
 	}


 	@SuppressWarnings("unchecked") 
 	public Comparable remove(){

 		if(index == 0){
 			System.out.println("PriorityQueue null, can't remove");
 			return null;
 		}

 		int maxIndex = 0;
 		// find idx with highest priority

 		for(int i = 1; i < index; i++){
 			if(pQueue[i].compareTo( pQueue[maxIndex] ) > 0 )
 				maxIndex = i;
 		}

 		Comparable res = pQueue[maxIndex];

 		index--;
 		pQueue[maxIndex] = pQueue[index];
 		System.out.println(res + " removed");

 		return res;

 	} 


 	public static void main(String[] args) {
 		PriorityQueue pq = new PriorityQueue(5);
        pq.insert(34);
        pq.insert(23);
        pq.insert(5);
        pq.insert(87);
        pq.insert(32);

        for(int i=0; i<5; i++)
        	pq.remove();
 	}

 }

/*------ OUTPUT -------

34 added
23 added
5 added
87 added
32 added
87 removed
34 removed
32 removed
23 removed
5 removed
[Finished in 2.0s]

 */