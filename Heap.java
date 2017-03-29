/****************************************************************************
 *     - "Heap" Data Structure
 *     -  This demonstrates binary heap operations along with heapSort.
 *****************************************************************************/
//  
// n个元素序列{k1,k2...ki...kn},当且仅当满足下列关系时称之为堆：
// (ki <= k2i,ki <= k2i+1)或(ki >= k2i,ki >= k2i+1), (i = 1,2,3,4...n/2)

import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>>{

  private static final int CAPACITY = 2;
  private int size;       // numper of elements in heap
  private AnyType[] heap; // heap array, e.g. int[] heap

  public Heap(){
    size = 0;
    heap = (AnyType[]) new Comparable[CAPACITY];
  }

  // consturctor binary heap given an array of items
  public Heap(AnyType[] array){
    size = array.length;
    heap = (AnyType[]) new Comparable[array.length+1];

    System.arraycopy(array, 0, heap, 1, array.length); // not 0 index
    buildHeap();
  }

  // runs at O(size)
  private void buildHeap(){
    for(int k = size/2; k>0; k--){
      percolatingDown(k);  // percolate 滲透
    }
  }

  private void percolatingDown(int k){
    AnyType tmp = heap[k];
    for(int child; k*2<=size; k=child){
      child = k*2;
      if(child!=size && heap[child].compareTo(heap[child+1])>0)
        child++;
      if(tmp.compareTo(heap[child])>0)
        heap[k] = heap[child];
      else
        break;
    }
    heap[k] = tmp;
  }

  // sort a given array of items
  public void heapSort(AnyType[] array){
    size = array.length;
    heap = (AnyType[]) new Comparable[size+1];
    System.arraycopy(array, 0, heap, 1, size);  // not 0 index
    buildHeap();

    for(int i=size; i>0; i--){
      AnyType tmp = heap[i]; // move top item to the end of heap array
      heap[i] = heap[1];
      heap[1] = tmp;
      size--;
      percolatingDown(1);
    }
    for(int k=0; k<heap.length-1; k++)
      array[k] = heap[heap.length-1-k];
  }

  // delete the top item
  public AnyType deleteMin() throws RuntimeException{
    if(size==0)
      throw new RuntimeException();
    AnyType min = heap[1];
    heap[1] = heap[size--];
    percolatingDown(1);
    return min;
  }

  // insert a new item
  public void insert(AnyType x){
    if(size==heap.length-1)
      doubleSize();
    // insert a new item to end of array
    int pos = ++size;

    // percolate up
    for(; pos>1 && x.compareTo(heap[pos/2])<0; pos=pos/2)
      heap[pos] = heap[pos/2];

    heap[pos] = x;
  }
  
  private void doubleSize(){
    AnyType[] old = heap;
    heap = (AnyType[]) new Comparable[heap.length*2];
    System.arraycopy(old, 1, heap, 1, size); 
  }

  @Override
  public String toString(){     // Override can delete
    String out = "";
    for(int k=1; k<=size; k++)
      out+= heap[k]+" ";
    return out;
  }


  public static void main(String[] args){

    Heap<String> h = new Heap<String>();

    h.insert("h");
    h.insert("e");
    h.insert("a");
    h.insert("p");
    System.out.println(h);
    h.deleteMin();
    System.out.println(h);

    Heap<Integer> tmp = new Heap<Integer>();
    Integer[] a = {4,7,7,7,5,0,2,3,5,1};
    tmp.heapSort(a);
    // System.out.println(a);
    System.out.println(Arrays.toString(a));

    
  }
}

/* 
@SuppressWarnings("unchecked")?
Sometimes Java generics just doesn't let you do what you want to, u need to
effectively tell compiler what you're doing really will be legal at execution time.



------- OUTPUT ----------

a h e p 
e h p 
[0, 1, 2, 3, 4, 5, 5, 7, 7, 7]
[Finished in 1.6s]


*/












