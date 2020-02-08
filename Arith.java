import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for prefix and postfix arithmetic expressions.
 *
 *  @author  Abhay Khanka
 */

public class Arith 
{

	public static boolean isOperator(String element) {
		switch(element){
		case "+": 
		case "-":
		case "/":
		case "*":
		return true;
		
		default: return false;
		}
	}
	
	public static int applyOperator(String operator,int num1, int num2) {
		switch(operator) {
		case "+": return num2+num1;
		case "-": return num2-num1;
		case "/": return num2/num1;
		case "*": return num2*num1;
		
		default: return 0;
		}
	}

  //~ Validation methods ..........................................................

	 /**
	    * Validation method for prefix notation.
	    *
	    * @param prefixLiterals : an array containing the numbers in string format in prefix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return true if the parameter is indeed in prefix notation, and false otherwise.
	    * 
	    * Explaination:
	    *  Total Cost: Theta(N) due to one for loop which accesses all the elements in array  
	    **/
	public static boolean validatePrefixOrder(String prefixLiterals[])
	   {
	     
	       int count = 1;  
	       for(String i : prefixLiterals) {
	    	  if(count==0) {
	    		  return false;
	    	  }
	    	  
	    	  if(isOperator(i)) {
	    		  count++;
	    	  }
	    	  else {
	    		  count--;
	    	  }
	       }
	       return (count==0);
	   }
	

	/**
	    * Validation method for Postfix notation.
	    *
	    * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return true if the parameter is indeed in postfix notation, and false otherwise.
	    * 
	   * Explaination:
	    *  Total Cost: Theta(N) due to recursion n number of times where n is the length of array
	    **/
	   public static boolean validatePostfixOrder(String postfixLiterals[])
	   {
	     
	       if(postfixLiterals==null || postfixLiterals.length ==0) 
	    	   return false;
	       
	       String [] prefix = convertPostfixToPrefix(postfixLiterals);
	       return validatePrefixOrder(prefix);
	   }
	   
  //~ Evaluation  methods ..........................................................


	   /**
	    * Evaluation method for prefix notation.
	    *
	    * @param prefixLiterals : an array containing the string literals in prefix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return the integer result of evaluating the expression
	    ** Explaination:
	    *  Total Cost: Theta(N) due to one for loop which accesses all the elements in array
	    *  */
	   public static int evaluatePrefixOrder(String prefixLiterals[])
	   {
	       String[] postfix = convertPrefixToPostfix(prefixLiterals);
	       return evaluatePostfixOrder(postfix);
	   }


	   /**
	    * Evaluation method for postfix notation.
	    *
	    * @param postfixLiterals : an array containing the string literals in postfix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return the integer result of evaluating the expression
	    * 
	    * Explaination:
	    *  Total Cost: Theta(N) due to one for loop which accesses all the elements in array 
	    *  **/
	   public static int evaluatePostfixOrder(String postfixLiterals[])
	   {
	       if(postfixLiterals==null || postfixLiterals.length ==0) return -1;
	       if(isOperator(postfixLiterals[0])) return -1;
	       
	       Stack<Integer> stack = new Stack<Integer>();
	       for(int i=0 ; i<postfixLiterals.length; i++){
	        
	    	   if(isOperator(postfixLiterals[i])){
	               int num1 = stack.pop();
	               int num2 = stack.pop();
	               stack.push(applyOperator(postfixLiterals[i],num1,num2));
	           }
	           else {
	             stack.push(Integer.parseInt(postfixLiterals[i]));  
	           }
	       }
	       return stack.peek();

	   }
	 //~ Conversion  methods ..........................................................	   
	   
	   /**
	    * Converts prefix to postfix.
	    *
	    * @param prefixLiterals : an array containing the string literals in prefix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return the expression in postfix order.
	    * 
	    * Explaination:
	    *  The total cost is Theta(N) because the largest number of loops such as for loop and while loop is one.
	    **/
	   public static String[] convertPrefixToPostfix(String prefixLiterals[])
	   {
	     //TODO
	       String[] result;
	       
	       Stack<String> stack = new Stack<String>();
	 
	       if(validatePrefixOrder(prefixLiterals))
	       {
	           String popValue1;
	           String popValue2;
	           for(int i=prefixLiterals.length-1; i>=0; i--)
	           {
	               if(isOperator(prefixLiterals[i]))
	               {
	            	   popValue1 = stack.pop();
	            	   popValue2 = stack.pop();
	                   String temp = popValue1 + " " + popValue2 + " " + prefixLiterals[i];
	                   stack.push(temp);
	               }
	               else
	               {
	                   stack.push(prefixLiterals[i]);
	               }
	           }
	           result = stack.peek().split(" ");
	           return result;
	       }
	 
	       return null;
	   }
	   
	   
	   
	   
	   public static String[] convertPostfixToPrefix(String postfixLiterals[]) {
		   if(postfixLiterals==null || postfixLiterals.length ==0) return null;
	       if(isOperator(postfixLiterals[0])) return null;
	       String[] result;
	       
	       Stack<String> stack = new Stack<String>();
	       
	       String popValue1;
	       String popValue2;
	       for(int i=0; i<postfixLiterals.length; i++)
	       {
	           if(isOperator(postfixLiterals[i])){
	               popValue2 = stack.pop();
	               popValue1 = stack.pop();
	               String temp = postfixLiterals[i] + " " + popValue1 + " " + popValue2 ;
	               stack.push(temp);
	           }
	           else{
	               stack.push(postfixLiterals[i]);
	           }
	       }
	       result = stack.peek().split(" ");
	       
	       if(validatePrefixOrder(result)) return result;
	       return null;
	   }
	   
	   /**
	    * Converts prefix to infix.
	    *
	    * @param infixLiterals : an array containing the string literals in prefix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return the expression in infix order.
	    **/
	   public static String[] convertPrefixToInfix(String prefixLiterals[])
	   {
		   Deque<String> operands = new ArrayDeque<>();
	        for (int i = prefixLiterals.length - 1; i >= 0; i--) {
	            String symbol = prefixLiterals[i];
	            if (!isOperator(symbol)) {
	                operands.push(symbol);
	            } else {
	                String num1 = operands.pop();
	                String num2 = operands.pop();
	                operands.push("( " + num1 + " " + symbol + " " + num2 + " )");
	            }
	        }
	        String[] result = operands.pop().split("\\ ");
	        return result;
	   }

	   /**
	    * Converts postfix to infix.
	    *
	    * @param infixLiterals : an array containing the string literals in postfix order.
	    * The method assumes that each of these literals can be one of:
	    * - "+", "-", "*", or "/"
	    * - or a valid string representation of an integer.
	    *
	    * @return the expression in infix order.
	    **/
	   public static String[] convertPostfixToInfix(String postfixLiterals[])
	   {
	     String[] tempArray = convertPostfixToPrefix(postfixLiterals);
	     return convertPrefixToInfix(tempArray);
	   }
}
	   


