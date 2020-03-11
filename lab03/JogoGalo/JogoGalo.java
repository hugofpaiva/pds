public class JogoGalo implements JGaloInterface{
	private char m[][] = new char[3][3];	// MATRIZ QUE GUARDA AS JOGADAS
	private char player='X';				// VARIÁVEL QUE INDICA QUAL O JOGADOR ATUAL
	private char winner='z';				// VARIÁVEL QUE INDICA, TEMPORARIAMENTE, QUAL O VENCEDOR
	private int counter=0;					// VARIÁVEL QUE ARMAZENA O NÚMERO DE JOGADAS
	public JogoGalo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	// FUNCÇÃO QUE DEVOLVE O JOGADOR ATUAL
	public char getActualPlayer() {
		return player;
	}

	@Override
	// FUNÇÃO QUE SUBSTITUI O JOGADOR ATUAL
	public boolean setJogada(int lin, int col) {
		this.counter++;
		m[lin-1][col-1]=player;
		if(this.player=='X') {
			this.player='O';
			return false;
		}else {
			this.player='X';
			return false;
		}
	}

	@Override
	// FUNÇÃO QUE VERIFICA SE O JOGO JÁ ACABOU
	public boolean isFinished() {
		// VERIFICA QUE A PRIMEIRA LINHA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][0] == m[0][1] && m[0][1] == m[0][2] && m[0][0]!=0) {
			winner=m[0][0];
			return true;
		}

		// VERIFICA QUE A SEGUNDA LINHA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[1][0] == m[1][1] && m[1][1] == m[1][2] && m[1][0]!=0) {
			winner=m[1][0];
			return true;
		}

		// VERIFICA QUE A TERCEIRA LINHA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[2][0] == m[2][1] && m[2][1] == m[2][2] && m[2][0]!=0) {
			winner=m[2][0];
			return true;
		}
		
		
		// VERIFICA QUE A DIAGONAL PRINCIPAL ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][0] == m[1][1] && m[1][1] == m[2][2] && m[0][0]!=0) {
			winner=m[0][0];
			return true;
		}

		// VERIFICA QUE A DIAGONAL SECUNDÁRIA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][2] == m[1][1] && m[1][1] == m[2][0] && m[0][2]!=0) {
			winner=m[0][2];
			return true;
		}
		
		// VERIFICA QUE A PRIMEIRA COLUNA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][0] == m[1][0] && m[1][0] == m[2][0] && m[0][0]!=0) {
			winner=m[0][0];
			return true;
		}

		// VERIFICA QUE A SEGUNDA COLUNA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][1] == m[1][1] && m[1][1] == m[2][1] && m[0][1]!=0) {
			winner=m[0][1];
			return true;
		}

		// VERIFICA QUE A TERCEIRA COLUNA ESTÁ PREENCHIDA POR UM MESMO SÍMBOLO (X/O)
		if(m[0][2] == m[1][2] && m[1][2] == m[2][2] && m[0][2]!=0) {
			winner=m[0][2];
			return true;
		}
		
		// VERIFICA SE JÁ FORAM FEITAS 9 JOGADAS, NESTE CASO, A CONDIÇÃO SÓ É VERDADEIRA SE NÃO PASSAR POR NENHUMA DAS OUTRAS VERIFICAÇÕES, LOGO É EMPATE
		if(counter==9) {
			winner=' ';
			return true;
		}else {
			winner='z';
			return false;
		}
	}

	@Override
	// RETORN X, O, (ESPAÇO)
	public char checkResult() {
		return winner;
	}

}
