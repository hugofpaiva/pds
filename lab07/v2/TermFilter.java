package LAB7.v2;

public class TermFilter  extends FileDecorator{
	String palavras[];
	int current_index=0;
	public TermFilter(FileInterface file) {
		super(file);
		palavras = super.next().split(" ");
	}
	
	public String next() {
		// Texto dividido em palavras
		if(current_index<palavras.length) {
			return palavras[current_index++];
		}
		return null;
	}

}
