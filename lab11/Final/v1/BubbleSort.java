package lab11.Final.v1;

import java.util.Comparator;

public class BubbleSort implements SortInterface{
	Telemovel[] lista;
	Comparator<Telemovel> comp;
	
	public BubbleSort(Telemovel[] t, Comparator<Telemovel> c)
    {
        lista = t;
        comp = c;
    }

    @Override
    public void sort() {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare(lista[j], lista[j + 1]) > 0) {
                    Telemovel temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
                
            }
            
        }
    }

}
