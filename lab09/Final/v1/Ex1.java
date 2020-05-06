import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;



public class Ex1 {

	public static void main(String[] args) {
		VectorGeneric<Pessoa> vp = new VectorGeneric<>();
		for (int i = 0; i < 10; i++)
			vp.addElem(new Pessoa("Some One " + i, 1000 + i, new Date(System.currentTimeMillis())));

		Iterator<Pessoa> vec = vp.iterator();
		while (vec.hasNext())
			System.out.println(vec.next());
		
		
		ListIterator<Pessoa> vec1 = vp.listIterator();
		while (vec1.hasNext())
			System.out.println(vec1.nextIndex());
		
		ListIterator<Pessoa> vec2 = vp.listIterator(1);
		while (vec2.hasPrevious())
			System.out.println(vec2.previousIndex());
	}

}
