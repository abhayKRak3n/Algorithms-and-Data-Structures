import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    
    @Test
    public void testIsEmpty() {
    	System.out.println("\nIs Empty method");
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0, 5);
    	 System.out.println(testDLL.isEmpty());
         assertEquals( "Check isEmpty method", false, testDLL.isEmpty() );
         
         DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
    	 System.out.println(testDLL2.isEmpty());
         assertEquals( "Check isEmpty method", true, testDLL2.isEmpty() );
         
        
    	 
    	
    	
    }
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
    	System.out.println("\nTest insertBefore method");
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);    
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    @Test
    public void testDeleteAt() {
    	 System.out.println("\nTest deleteAt Method");
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0,1);
         testDLL.insertBefore(1,2);
         testDLL.insertBefore(2,3);
         testDLL.insertBefore(0,4);
         testDLL.insertBefore(50,7);
         System.out.println(testDLL.toString());
         
         testDLL.deleteAt(0);
         System.out.println(testDLL.toString());
         assertEquals( "Checking deleteAt to see if element is deleted at position 0", "1,2,3,7", testDLL.toString() );
         testDLL.deleteAt(1);
         System.out.println(testDLL.toString());
         assertEquals( "Checking deleteAt to see if element is deleted at position 1", "1,3,7", testDLL.toString() );
         testDLL.deleteAt(2);
         System.out.println(testDLL.toString());
         assertEquals( "Checking deleteAt to see if element is deleted at position 2", "1,3", testDLL.toString() );

         DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
         testDLL2.insertBefore(0, 5);
         assertEquals( "Checking deleteAt to see if element is deleted at position 2", false, testDLL2.deleteAt(1) );
         
    }
   
    @Test
    public void testGet() {
    	System.out.println("\nTest Get Method");
   	    DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
   	    testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(50,7);
        testDLL.insertBefore(11,9);
        testDLL.insertBefore(50,11);
        testDLL.insertBefore(0,27);
        System.out.println(testDLL.toString());
        
        testDLL.get(0);
        System.out.println("Pos 0 = "+testDLL.get(0));
        assertEquals( "Checking get to see if element is obtained from position 0 is", "27", testDLL.get(0).toString() );
        
        testDLL.get(7);
        System.out.println("Pos 7 = "+testDLL.get(7));
        assertEquals( "Checking get to see if element is obtained from position 7 is", "11", testDLL.get(7).toString() );
        
        testDLL.get(3);
        System.out.println("Pos 3 = "+testDLL.get(3));
        assertEquals( "Checking get to see if element is obtained from position 3 is", "2", testDLL.get(3).toString() );
    
        testDLL.get(9);
        System.out.println("Pos 9 = "+testDLL.get(9));
        assertEquals( "Checking get to see if element's position more than list size is", null, testDLL.get(9) );
    
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,1);
        //System.out.println(testDLL2.get(2).toString());
        assertEquals( "Checking get to see if element is obtained from position 3 is", null, testDLL2.get(1) );
        assertEquals( "Checking get to see if element is obtained from position 3 is", "1", testDLL2.get(0).toString() );
        
    }
    
    @Test
    public void testReverse() {
    	System.out.println("\nTest Reverse Method");
   	    DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
   	    testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(50,7);
        testDLL.insertBefore(11,9);
        testDLL.insertBefore(50,11);
        testDLL.insertBefore(0,27);
        System.out.println(testDLL.toString());
        
        testDLL.reverse();
        System.out.println(testDLL.toString());
        assertEquals( "Checking Reverse Method ", "11,9,7,3,2,1,4,27", testDLL.toString() );
        
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.reverse();
        System.out.println(testDLL2);
        assertEquals( "Checking Reverse Method ", "", testDLL2.toString());
        
    }
    
    //Make changes for 3 digits
    @Test
    public void testMakeUnique() {
    	System.out.println("\nTest Make Unique Method");
   	    DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
   	    
   	    testDLL.makeUnique();
   	    assertEquals( "Checking MakeUnique Method ", true, testDLL.isEmpty() );
   	    testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,4);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(50,7);
        testDLL.insertBefore(11,27);
        testDLL.insertBefore(0,27);
        //testDLL.insertBefore(50,1);
        //testDLL.insertBefore(6,1);
       
        System.out.println(testDLL.toString());
        
        
        testDLL.makeUnique();
        System.out.println(testDLL.toString());
        assertEquals( "Checking MakeUnique Method ", "27,4,1,2,7", testDLL.toString() );
        
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,2);
        testDLL2.insertBefore(0,2);
        testDLL2.insertBefore(0,2);
        testDLL2.insertBefore(0,2);
        testDLL2.insertBefore(50,1);
        testDLL2.insertBefore(11,1);
        testDLL2.insertBefore(10,1);
        testDLL2.insertBefore(10,1);
        testDLL2.insertBefore(10,1);
       
        System.out.println(testDLL2.toString());
        
        testDLL2.makeUnique();
        System.out.println(testDLL2.toString());
        assertEquals( "Checking MakeUnique Method ", "2,1", testDLL2.toString() );
        
    }
  
    @Test
    public void testPush() {
    	System.out.println("\nTest push method");
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        System.out.println(testDLL.toString());
        
        testDLL.push(5);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3,5", testDLL.toString() );

        testDLL.push(4);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3,5,4", testDLL.toString() );

    }
    
    @Test
    public void testPop() {
    	System.out.println("\nTest pop method");
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.push(5);
        testDLL.push(4);
        System.out.println(testDLL.toString());
        
        testDLL.pop();
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3,5", testDLL.toString() );
        testDLL.pop();
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );

    }
    
    @Test
    public void testEnque() {
    	System.out.println("\nTest Enque method");
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(5);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "5", testDLL.toString() );
        
        testDLL.enqueue(7);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "5,7", testDLL.toString() );
        
        testDLL.enqueue(9);
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "5,7,9", testDLL.toString() );
        
    }
    
    @Test
    public void testdequeue() {
    	System.out.println("\nTest Dequeue method");
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(5);
        testDLL.enqueue(7);
        testDLL.enqueue(9);
        System.out.println(testDLL.toString());
        
        testDLL.dequeue();
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "7,9", testDLL.toString() );
       
        testDLL.dequeue();
        System.out.println(testDLL.toString());
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "9", testDLL.toString() );
      
    }
    @Test 
	public void random() {
    	 
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.push(2);
    	 testDLL.push(1);
    	 testDLL.push(2);
    	 testDLL.push(1);
    	 testDLL.push(1);
    	 testDLL.push(2);
    	 testDLL.push(1);
    	 testDLL.makeUnique();
    	 
    	 assertEquals( "Checking MakeUnique Method ", "2,1", testDLL.toString() );
    	 
    	 assertEquals( "Checking get to see if element is obtained from position 0 is", null, testDLL.get(2) );
         
	}
    

}