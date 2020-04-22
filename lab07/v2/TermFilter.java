public class TermFilter  extends FileDecorator{
	String palavras[];
	int current_index=0;

	/*
		*
		* O VETOR PALAVRAS VAI GUARDAR TODOS OS ELEMENTOS DO PARÁGRAFO DEVOLVIDO PELO TextReader SEPARADOS POR ESPAÇO
		* É GUARDADO O ÍNDICE QUE DEVE SER LIDO QUANDO CHAMADA A FUNÇÃO NEXT() PARA QUE SEJA DEVOLVIDO A PALAVRA PEDIDA
		*
	 */

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
