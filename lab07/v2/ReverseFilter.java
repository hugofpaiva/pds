package LAB7.v2;

public class ReverseFilter  extends FileDecorator{

	public ReverseFilter(FileInterface file) {
		super(file);
	}

	public String next() {
		// Texto invertido
		String w = super.next();
		String new_text="";
		for(int i=w.length()-1; i>=0; i--) {
			new_text+=w.charAt(i);
		}
		return new_text;
	}

}
