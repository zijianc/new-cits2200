package CITS2200;

import CITS2200.Sort;

/**
 * A class to give a comaprative view of common sorting algorithms. The
 * maintains a private static variable that counts the number of array
 * assignments that are performed (as an approximate measure of the complexity
 * of the algorithm.
 * 
 * @author Tim French.
 **/

public class Sorter implements Sort {

	private int count;

	/**
	 * Returns the number of array assignment operations performed by this class
	 * since the count variable was rest.
	 * 
	 * @return the number of assignments
	 **/
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Resets the counter variable to 0
	 **/
	public void reset() {
		count = 0;
	}

	/**
	 * Executes the insertion sort algorithm sorting the argument array. There
	 * is no return as the parameter is to be mutated.
	 * 
	 * @param a
	 *            the array of long integers to be sorted
	 **/
	public void insertionSort(long[] a) {

		// insert your code here
		if (a != null) {
			for (int i = 1; i < a.length; i++) {
				long temp = a[i];
				int j = i;
				if (a[j - 1] > temp) {
					while (j >= 1 && a[j - 1] > temp) {
						a[j] = a[j - 1];
						j--;
					}
				}
				a[j] = temp;
			}
		}

	}

	public static void main(String[] args) {
		Sorter s = new Sorter();
		long[] a = new long[] { 5, 1, 3, 3, 2, 6, 0, 5, 4, 0 };
		s.mergeSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	/**
	 * Executes the quick sort algorithm sorting the argument array. There is no
	 * return as the parameter is to be mutated.
	 * 
	 * @param a
	 *            the array of long integers to be sorted
	 **/
	public void quickSort(long[] a) {
		// insert your code here.
		// you will also need to provide some private methods

	}

	public void Sort(long[] a, int low, int high) {
		int i, j;
		long index;
		if (low >= high)
			return;
		i = low;
		j = high;
		index = a[i];
		while (i < j) {
			while (i < j && index <= a[j])
				j--;
			if (i < j) {
				a[i++] = a[j];
			}
			while (i < j && index > a[i])
				i++;
			if (i < j)
				a[j--] = a[i];

		}
		a[i] = index;
		Sort(a, low, i - 1);
		Sort(a, i + 1, high);

	}

	/**
	 * Executes the merge sort algorithm sorting the argument array. There is no
	 * return as the parameter is to be mutated.
	 * 
	 * @param a
	 *            the array of long integers to be sorted
	 **/
	public void mergeSort(long[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	/**
	 * A private method to merge the elements in the array between p and r. the
	 * array a, between the indices p and r, inclusive. Given the array is
	 * sorted between p and q and q+1 and r sorts the array between p and r.
	 * 
	 * @param a
	 *            the array to be sorted, which is mutated by the method
	 * @param p
	 *            the lower index of the range to be partitioned
	 * @param q
	 *            the midpoint of the two sorted sections.
	 * @param r
	 *            the upper index of the range to be paritioned
	 * @return the index of the point of partition
	 **/
	 public static void merge(long array[], int p, int q, int r) {
		 int n1 = q - p + 1;
		    int n2 = r - q;

		    long L[] = new long[n1];
		    long M[] = new long[n2];

		    // fill the left and right array
		    for (int i = 0; i < n1; i++)
		      L[i] = array[p + i];
		    for (int j = 0; j < n2; j++)
		      M[j] = array[q + 1 + j];

		    // Maintain current index of sub-arrays and main array
		    int i, j, k;
		    i = 0;
		    j = 0;
		    k = p;

		    // Until we reach either end of either L or M, pick larger among
		    // elements L and M and place them in the correct position at A[p..r]
		    // for sorting in descending
		    // use if(L[i] >= <[j])
		    while (i < n1 && j < n2) {
		      if (L[i] <= M[j]) {
		        array[k] = L[i];
		        i++;
		      } else {
		        array[k] = M[j];
		        j++;
		      }
		      k++;
		    }

		    // When we run out of elements in either L or M,
		    // pick up the remaining elements and put in A[p..r]
		    while (i < n1) {
		      array[k] = L[i];
		      i++;
		      k++;
		    }

		    while (j < n2) {
		      array[k] = M[j];
		      j++;
		      k++;
		    }
	 }

	/**
	 * Overloads the mergeSort method with parameters to set the range to be
	 * sorted.
	 **/
	private void mergeSort(long[] a, int p, int r) {
		if(p<r){
			int q =(p+r)/2;
			mergeSort(a,p,q);
			mergeSort(a,q+1,r);
			merge(a,p,q,r);
		}
	}

}
