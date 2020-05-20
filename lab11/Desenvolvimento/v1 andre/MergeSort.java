package LAB11.v1;

import java.util.Comparator;

public class MergeSort implements SortInterface{
	Telemovel[] lista;
	static Comparator<Telemovel> comp;
	
	public MergeSort(Telemovel[] t, Comparator<Telemovel> c) {
		lista=t;
		comp=c;
	}

	@Override
	public void sort() {
		System.out.println("Ordenado com MergeSort");
		mergeSort(lista, 0, lista.length-1);
	}
	
	public static void mergeSort(Telemovel[] array, int left, int right) {
	    if (right <= left) return;
	    int mid = (left+right)/2;
	    mergeSort(array, left, mid);
	    mergeSort(array, mid+1, right);
	    merge(array, left, mid, right);
	}
	
	private static void merge(Telemovel[] array, int left, int mid, int right) {
	    // calculating lengths
	    int lengthLeft = mid - left + 1;
	    int lengthRight = right - mid;

	    // creating temporary subarrays
	    Telemovel leftArray[] = new Telemovel [lengthLeft];
	    Telemovel rightArray[] = new Telemovel [lengthRight];

	    // copying our sorted subarrays into temporaries
	    for (int i = 0; i < lengthLeft; i++)
	        leftArray[i] = array[left+i];
	    for (int i = 0; i < lengthRight; i++)
	        rightArray[i] = array[mid+i+1];

	    // iterators containing current index of temp subarrays
	    int leftIndex = 0;
	    int rightIndex = 0;

	    // copying from leftArray and rightArray back into array
	    for (int i = left; i < right + 1; i++) {
	        // if there are still uncopied elements in R and L, copy minimum of the two
	        if (leftIndex < lengthLeft && rightIndex < lengthRight) {
	            if (comp.compare(leftArray[leftIndex],rightArray[rightIndex]) < 0) {
	                array[i] = leftArray[leftIndex];
	                leftIndex++;
	            }
	            else {
	                array[i] = rightArray[rightIndex];
	                rightIndex++;
	            }
	        }
	        // if all the elements have been copied from rightArray, copy the rest of leftArray
	        else if (leftIndex < lengthLeft) {
	            array[i] = leftArray[leftIndex];
	            leftIndex++;
	        }
	        // if all the elements have been copied from leftArray, copy the rest of rightArray
	        else if (rightIndex < lengthRight) {
	            array[i] = rightArray[rightIndex];
	            rightIndex++;
	        }
	    }
	}

}
