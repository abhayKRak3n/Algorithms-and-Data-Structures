
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
   
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode)
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    public int size;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList()
    {
      head = null;
      tail = null;
      size = 0;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  The methods just compares the head and the tail to null, which will always have constant running time
     *  
     */
    public boolean isEmpty()
    {
      return (head == null && tail == null);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  in the worst case i.e when the program goes into a for loop, which will have a
     *  running time of O(n), while all the other cases are assignments, which have
     *  the running time of O(1)
     */
    public void insertBefore( int pos, T data )
    {
    	if(isEmpty()) {
			DLLNode node = new DLLNode(data,null,null);
			head = node;
			tail = node;
		}
		else if(pos<=0) {
			DLLNode temp = this.head; 
			this.head = new DLLNode(data, null, temp); 		//insertion at head
			(this.head).next = temp;
			temp.prev = this.head;

		}
		else {
			DLLNode node = this.head;
			for(int i=0; i<size ; i++) {
				if(node.next==null){		//insertion at tail
					DLLNode temp = tail;
					tail = new DLLNode(data,tail,null);
					temp.next = tail;
				}
				else if(i==(pos-1)) { //insertion in between
					DLLNode temp = node.next;
					DLLNode newNode =  new DLLNode(data,node,temp);
					node.next = newNode;
					temp.prev = newNode;

				}
				node = node.next;
			}
		}
		size++;	
    }
   
    //method to calculate size of list
    public int calcSize() {
     if(isEmpty()) {
    	 return 0;
     }
     
     int i=0;
     DLLNode element=head; 
     while(element.next!=null) {
    	 i++;
    	 element = element.next;
     }
     return i;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  for the worst case, i.e when position will be somewhere in the middle
     *  we will have to use for case to iterate till that position
     *  therefore we will have running time o(n) due to the for loop
     */
    public T get(int pos)
    {
    	if(isEmpty()||pos<0||pos>size-1) {
    			return null;
    }
   
    else if(pos==0) {
    	return head.data;
    }
    	
  //  else if (pos == calcSize()) {
   // 	return tail.data;
   // }
    DLLNode retValue = head;
    for(int i=0; i<pos ; i++) {
    	retValue = retValue.next;
    }
    return retValue.data;
  }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  this is because there will be a for loop which will have a running time for O(n)
     *  while in the rest of the lines assignment takes place which has a running time of O(1)
     *  i.e constant
     */
    public boolean deleteAt(int pos)
    {
    	//int s = calcSize();
    if(isEmpty() || pos>size-1 || pos<0) {
    return false;
    }
   
    DLLNode node = head;  
    for(int i=0; i<pos ; i++) {
    	node = node.next;
    }
   
    DLLNode previousElement = node.prev;
    DLLNode nextElement = node.next;
    if(previousElement!=null) { //checks if pos is at head or tail
    	previousElement.next = nextElement;
    }
   
    else {
    	head = nextElement;
    }
   
    if(nextElement!=null) {
    	nextElement.prev = previousElement;
    }
    else {
    	tail = previousElement;
    }
    
      size--;    
      return true;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  O(n) because of the for loop
     *  
     */
    public void reverse()
    {
    if(!isEmpty()) {
    	DLLNode node = head;
    	DLLNode temp;
    	int s = calcSize();
   
    	for(int i=s; i>=0; i--) {
    		temp = node.next;
    		node.next = node.prev; //swapping next and prev elements
    		node.prev = temp;
    		node = temp;
    	}
   
    	DLLNode swap = head; //swap head and tail at the end
    	head = tail;
    	tail = swap;
    }
}

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(n^2)
     *
     * Justification:
     *  O(n^2) because there exists one for loop and one while loop (inside the for loop)
     *  whose product is O(n^2)
     *  
     */
     public void makeUnique()
    {
    if(!isEmpty()) {
    	DLLNode node = head;
    	for(int i=0; i<size; i++) {
    			DLLNode next = node.next;
    			int j = i+1;
    			while(j<size) {
    					if(node.data==next.data) {
    							deleteAt(j);
    							j--;
    					}
    					next = next.next;
    					j++;
    			}
    		node = node.next;
    	}
    }
}


    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  because the function calls insert before function which has a worst case run time of O(n)
     *  and the only action taking other than that is calcSize which is also O(n)
     */
    public void push(T item)
    {
    insertBefore(size+1,item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(n^2)
     *
     * Justification:
     *  this is because the function calls a deleteBefore(O(n) time) method inside a for loop
     *  thus the product being O(n^2)
     */
    public T pop()
    {
    	if(isEmpty()) {
    			return null;
    	}
   
    	int pos = size+1;
    	DLLNode node = head;
    	for(int i=0; i<pos;i++) {
    			if(node.next==null) {
    				DLLNode temp = node;
    				deleteAt(i);
    				return temp.data;
    			}
    			node = node.next;
    	}
   
      return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  because the function calls insertBefore method which has a running time of O(n)
     *  
     */
    public void enqueue(T item)
    {
    	insertBefore(size+1,item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification:
     *  this is because the function calls on deleteAt function which has a running time of O(n)
     *  Other than that, assignments take place which have constant running times
     */
    public T dequeue()
    {
    	if(isEmpty()) {
    		return null;
    	}
   
    	DLLNode temp = head;
    	deleteAt(0);  
    	return temp.data;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString()
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true;

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }
}