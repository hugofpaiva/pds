import java.util.ArrayList;
public class Board{
    int width;
    int height;
    ArrayList<Ship> ships = new ArrayList<>();
    int[][] tabuleiro = new int[25][25];
    public Board(int width, int height){
        this.width=width;
        this.height=height;
    }

    public boolean fillPos(int x, int y, Ship barco){
        if(x<0 || x>width || y<0 || y>height || tabuleiro[x][y]!=0){ // VERIFICA SE (uma parte do barco) PODE SER COLOCADA NUMA DADA POSIÇÃO
            return false;
        }
        tabuleiro[x][y]=barco.Id();
        return true;
    }

    public void fillBoard(){
        for (Ship ship : ships) {
			int orientation = (int) (8 * Math.random());
            int initx = (int) (width + 1 * Math.random());
			int inity = (int) (height + 1 * Math.random());
            boolean nonChoosen = true;

            while(nonChoosen){
                if(){
                    
                }
            }
			

            int incx=1;
            int incy=1;
			switch (orientation) {
				case 0: // ESQUERDA
                    incx=-1;
                    incy=0;
					break;
				case 1: // CIMA
                    incx=0;
                    incy=-1;
					break;
				case 2: // DIREITA
                    incx=1;
                    incy=0;
					break;
				case 3: // BAIXO
                    incx=0;
                    incy=1;
					break;
                case 4: // ESQUERDA CIMA
                    incx=-1;
                    incy=-1;
					break;
				case 5: // DIREITA CIMA
                    incx=1;
                    incy=-1;
					break;
				case 6: // DIREITA BAIXO
                    incx=1;
                    incy=1;
					break;
				case 7: // ESQUEDA BAIXO
                    incx=-1;
                    incy=1;
					break;
				default:
					System.err.println("ERRO");
			}

            for(int i=){

            }

		}
    }
}