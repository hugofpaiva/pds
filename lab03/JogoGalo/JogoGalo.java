package lab03.JogoGalo;

public class JogoGalo implements JGaloInterface {
	private char galo[][] = new char[3][3];
	private char player;
	private char winner;
	private int counter;

	public JogoGalo() {
		// TODO Auto-generated constructor stub
	}

	public JogoGalo(char player) {
		this.player = player;
	}

	@Override
	public char getActualPlayer() {
		return player;
	}

	@Override
	public boolean setJogada(int lin, int col) {
		galo[lin-1][col-1] = player;
		if(player == 'X') {
			player = 'O';
		}
		else if (player == 'O') {
			player = 'X';
		}
		return true;
	}

	@Override
	public boolean isFinished() {
		counter++;
		//3 colunas
		if(galo[0][0] == galo[0][1] && galo[0][1] == galo[0][2] && galo[0][0]!=0) {
		winner=galo[0][0];
		return true;
		}
		if(galo[1][0] == galo[1][1] && galo[1][1] == galo[1][2] && galo[1][0]!=0) {
		winner=galo[1][0];
		return true;
		}
		if(galo[2][0] == galo[2][1] && galo[2][1] == galo[2][2] && galo[2][0]!=0) {
		winner=galo[2][0];
		return true;
		}
		//diagonais
		if(galo[0][0] == galo[1][1] && galo[1][1] == galo[2][2] && galo[0][0]!=0) {
		winner=galo[0][0];
		return true;
		}
		if(galo[0][2] == galo[1][1] && galo[1][1] == galo[2][0] && galo[0][2]!=0) {
		winner=galo[0][2];
		return true;
		}

		//3 linhas
		if(galo[0][0] == galo[1][0] && galo[1][0] == galo[2][0] && galo[0][0]!=0) {
		winner=galo[0][0];
		return true;
		}
		if(galo[0][1] == galo[1][1] && galo[1][1] == galo[2][1] && galo[0][1]!=0) {
		winner=galo[0][1];
		return true;
		}
		if(galo[0][2] == galo[1][2] && galo[1][2] == galo[2][2] && galo[0][2]!=0) {
		winner=galo[0][2];
		return true;
		}

		if(counter==9) {
		winner=' ';
		return true;
		}else {
		return false;
		}
	}

	@Override
	public char checkResult() {
		return winner;
	}

}
