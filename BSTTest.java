import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Check pretty printing of empty tree", "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        7
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    3      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Check order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Delete non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Delete leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Delete node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Delete node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     @Test
     public void testHeightIsEmpty()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals(bst.height(), -1);
     }
     
     @Test
     public void testHeightSize1()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(2, 1);
    	 assertEquals(bst.height(), 0);
     }
     
     @Test
     public void testHeight()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);       
         bst.put(8, 8);       
         bst.put(3, 3);
         bst.put(1, 1);
         bst.put(2, 2);
         assertEquals(bst.height(), 3);
     }
     
     @Test
     public void testMedianIsEmpty()
     {
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 assertEquals(bst.median(), null);
     }
     
     @Test
     public void testMedianSize1()
     {
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 bst.put("A", 1);
    	 assertEquals(bst.median(), "A");
     }
     
     @Test
     public void testMedian()
     {
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 bst.put("A", 1);
    	 bst.put("B", 2);
    	 bst.put("C", 3);
    	 assertEquals(bst.median(), "B");
    	 bst.put("D", 5);
    	 bst.put("E", 4);
    	 bst.put("F", 4);
    	 assertEquals(bst.median(), "C");
     }
     
     @Test
     public void testPrintKeysInOrderEmpty()
     {
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 assertEquals("()", bst.printKeysInOrder());
     }
     
     @Test
     public void testPrintKeysInOrderSize1()
     {
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 bst.put("A", 2);
    	 assertEquals("(()A())", bst.printKeysInOrder());
     }
     
     @Test
     public void testPrintKeysInOrder()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);       
         bst.put(8, 8);       
         bst.put(3, 3);
         bst.put(1, 1);
         bst.put(2, 2);
         bst.put(6, 6);
         bst.put(4, 4);
         bst.put(5, 5);
         assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
     }
     
     @Test
     public void testGet()
     {
    	 
    	 BST<String, Integer> bst = new BST<String, Integer>();
    	 bst.put("A", 2);
    	 bst.put("C", 3);
    	 assertNull(bst.get("B"));
     }
     
     @Test
     public void testPut()
     {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);       
    	 assertEquals(bst.printKeysInOrder(), "(()7())");  
         bst.put(8, 8);       
         bst.put(3, 3);
         bst.put(1, 1);
         bst.put(2, 2);
         bst.put(6, 6);
         bst.put(4, 4);
         bst.put(5, 5);
         assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
     }
     
     @Test
	 public void testContains()
	 {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking on a null key",false, bst.contains(bst.median())); 
	     bst.put(7, 7);   //        7
	     bst.put(8, 8);   //      /     \
	     bst.put(3, 3);   //    3      8
	     bst.put(1, 1);   //  /     \
	     bst.put(2, 2);   // 1       6
	     bst.put(6, 6);   //  \     /
	     bst.put(4, 4);   //   2   4
	     bst.put(5, 5);   //        \
	                      //         5
	     assertEquals("Checking on a null key",true, bst.contains(bst.median())); 
	 }
}