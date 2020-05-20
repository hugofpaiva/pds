package LAB11.v1;

import java.util.Comparator;

public class QuickSort implements SortInterface{
	Telemovel[] lista;
	static Comparator<Telemovel> comp;
	
	public QuickSort(Telemovel[] t, Comparator<Telemovel> c) {
		lista=t;
		comp=c;
	}

	@Override
	public void sort() {
		System.out.println("Ordenado com QuickSort");
		quickSort(lista, 0, lista.length-1);
	}
	
	static int partition(Telemovel[] array, int begin, int end) {
	    int pivot = end;

	    int counter = begin;
	    for (int i = begin; i < end; i++) {
	        if (comp.compare(array[i], array[pivot])<0) {
	        	Telemovel temp = array[counter];
	            array[counter] = array[i];
	            array[i] = temp;
	            counter++;
	        }
	    }
	    Telemovel temp = array[pivot];
	    array[pivot] = array[counter];
	    array[counter] = temp;

	    return counter;
	}

	public static void quickSort(Telemovel[] array, int begin, int end) {
	    if (end <= begin) return;
	    int pivot = partition(array, begin, end);
	    quickSort(array, begin, pivot-1);
	    quickSort(array, pivot+1, end);
	}

}
