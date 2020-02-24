import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author  Abhay Singh Khanka 
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	for(int i=1;i<a.length;i++) {
    		for(int j=i;j>0;j--) {
    			if(a[j]<a[j-1]) {
    				double temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}
    	}

    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        for (int i=0;i<a.length-1;i++) {
        	int minElement = i;
        	
        	for(int j=i+1;j<a.length;j++) {
        		if(a[minElement]>a[j]) 
        			minElement = j;
        	}
        	
        	double temp = a[minElement];
        	a[minElement] = a[i];
        	a[i] = temp;
        }
  
    	return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    public static double[] quickSort (double a[]){
    	assert a!=null;
    	sortQuick(a,0,a.length-1);
    	return a;
		
    }//end quicksort
    
    private static void sortQuick(double a[], int low, int high) {
    	if(high<=low) {
    		return;
    	}
    	
    	int pivot = partition(a,low,high);
    	sortQuick(a,low,pivot-1);
    	sortQuick(a,pivot+1,high);
    }
    
    private static int partition(double[] a, int low, int high) {
    	double pivot = a[high];  
        int j = (low-1); 
        int i;
        double temp;
        for (i=low; i<high; i++) {  
            if (a[i] < pivot)  { 
                j++;             
                temp = a[j]; 
                a[j] = a[i]; 
                a[i] = temp; 
            } 
        } 
 
        temp = a[j+1]; 
        a[j+1] = a[high]; 
        a[high] = temp; 
  
        return j+1; 
      }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		int low = 0;
		int high = a.length - 1;

		double[] temp = Arrays.copyOf(a, a.length);
		
		for (int m = 1; m <= high - low; m = 2*m){
			for (int i = low; i < high; i += 2*m){
				int from = i;
				int mid = i + m - 1;
				int to = Math.min(i + 2 * m - 1, high);

				merge(a, temp, from, mid, to);
			}
		}
		return a;
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    public static double[] mergeSortRecursive(double[] a) {
        assert a != null;
        
        double[] temp = new double[a.length];
        mergeSortRecursive(a, temp, 0, a.length - 1);
        return a;
      }//end mergeSortRecursive
    	
    private static void mergeSortRecursive(double[] a, double[] temp, int low, int high) {
        if (high <= low) 
        	return;
        
        int mid = low + (high - low) / 2;
        mergeSortRecursive(a, temp, low, mid);
        mergeSortRecursive(a, temp, mid + 1, high);
        merge(a, temp, low, mid, high);
      }
    
    private static void merge(double a[], double temp[], int low, int mid, int high)
    {
    	System.arraycopy(a, low, temp, low, high - low + 1);

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
          if (i > mid) 
        	  a[k] = temp[j++];
          
          else if (j > high)
        	  a[k] = temp[i++];
          
          else if (a[j] < temp[i])
        	  a[k] = temp[j++];
          
          else 
        	  a[k] = temp[i++];
        }
   }
    
    
 }//end class
