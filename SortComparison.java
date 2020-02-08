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
    static void quickSort (double a[]){
    	sortQuick(a,0,a.length-1);
    	
		
    }//end quicksort
    
    private static void sortQuick(double a[], double low, double high) {
    	if(high<=low) {
    		return;
    	}
    	
    	double pivot = partition(a,low,high);
    	sortQuick(a,low,pivot-1);
    	sortQuick(a,pivot+1,high);
    }
    
    private static double partition(double a[],double low, double high) {
    	double pivot = a[(int)high];
    	int i = (int)(low - 1);
    	double temp;
    	
    	for(int j=0;j<a.length;j++) {
    		if(a[j]<pivot) {
    			i++;
    			temp = a[i];
    			a[i] = a[j];
    			a[j] = temp;
    		}
    	}
    	
    	temp = a[i+1]; 
        a[i+1] = a[(int)high]; 
        a[(int)high] = temp; 
        
    	return i+1;
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
    	if(a==null) {
    		return null;
    	}
    	
    	if(a.length>1) {
    		double mid = a.length/2;
    		
    		double[] left = new double[(int)mid];
    		double[] right = new double[a.length-(int)mid];
    		int i,j,k;    		
    		
    		for(i=0;i<left.length;i++) {
    			left[i] = a[i];
    		}
    		
    		//CHECK HERE COULD BE AN ERROR
    		
    		for(i=0;i<right.length;i++) {
    			right[i] = a[(int)mid+i+1];
    		}
    		
    		i=0;
    		j=0;
    		k=0;
    		while(i<left.length && j<right.length) {
    			if(left[i]<right[j]) {
    				a[k++] = left[i++];
    			}
    			
    			else {
    				a[k++] = right[j++];
    			}
    		}
    		
    		while(i<left.length) {
    			a[k++] = left[i++];
    		}
    		
    		while(j<right.length) {
    			a[k++] = right[j++];
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
    static double[] mergeSortRecursive (double a[]) {
    	
    	sortMerge(a,0,a.length-1);
    	return a;
	
   }//end mergeSortRecursive
    	
    private static void sortMerge(double[] a, double low, double high) {
    	if(low<high) {
    		double mid = (low + high)/2;
    		
    		sortQuick(a,low,mid);
    		sortQuick(a,mid+1,high);
    		
    		merge(a,low,mid,high);
    	}
    	
    }
    
    private static void merge(double[] a, double low, double mid, double high) {
    	int i,j,k;
    	
    	int s1 = (int)(mid-low+1.0);
    	int s2 = (int)(high-mid);
    	
    	double[] left = new double[s1];
    	double[] right = new double[s2];
    	
    	for(i=0;i<s1;i++) {
    		left[i] = a[(int)low + i];
    	}
    	
    	for(j=0;j<s2;j++) {
    		right[j] = a[(int)mid + 1 + j];
    	}
    	
    	i=0;
    	j=0;
    	k=0;
    	
    	while(i<s1 && j<s2) {
    		if(left[i]<=right[j]) {
    			a[k] = left[i++];
    		}
    		
    		else {
    			a[k] = right[j++];
    		}
    		
    		k++;
    	}
    	
    	while(i<s1) {
    		a[k++] = left[i++];
    	}
    	
    	while(j<s2) {
    		a[k++] = right[j++];
    	}
    	
    }
    

    
    public static void main(String[] args) {
    	
        
    }

 }//end class