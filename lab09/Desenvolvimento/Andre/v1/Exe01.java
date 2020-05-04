
package LAB9.v1;

import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class Exe01 {
	public static void main(String[] args) {
		VectorGeneric<Person> vp = new VectorGeneric<>(); 
		for (int i=0; i<10; i++)
			vp.addElem(new Person("Someone "+i, 1000+i, new Date(System.currentTimeMillis())));
		System.out.println("Iterator");
		Iterator<Person> vec = vp.iterator(); 
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		
		System.out.println("ListIterator (index=0)");
		ListIterator<Person> vec2 = vp.listIterator(); 
		while ( vec2.hasNext() )
			System.out.println( vec2.next() );
		
		System.out.println("ListIterator (index=5)");
		ListIterator<Person> vec3 = vp.listIterator(5); 
		while ( vec3.hasNext() ) {
			System.out.println( vec3.next() );
		}
		while ( vec3.hasPrevious() ) {
			System.out.println( vec3.previous() );
		}
	}
}
