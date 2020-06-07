package LAB13;


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

    public void addShip(Ship s){
        ships.add(s);
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

            // POSIÇÕES EM QUE O BARCO COMEÇA A SER DESENHADO
            int initx=0;
			int inity=0;

            // VERIFICA SE A ORIENTAÇÃO E POSIÇÕES JÁ FORAM ESCOLHIDAS
            boolean choosen = false;

            // INCREMENTADORES TANTO PARA O X COMO PARA O Y
            int incx=1;
            int incy=1;

            // TODO: AINDA NÃO VERIFICA SE JÁ EXISTE ALGUM BARCO NUMA POSIÇÃO
            while(!choosen){
            	System.out.println("---Escolha---");
                orientation = (int) (8 * Math.random());
                initx = (int) (width * Math.random());
                inity = (int) (height * Math.random());
                switch (orientation) {
                    case 0: // ESQUERDA
                    	
                        if(initx - ship.Size() >= 0)
                            choosen=true;
                        incx=-1;
                        incy=0;
                        
                        break;
                    case 1: // CIMA
                    	
                        if(inity - ship.Size() >= 0)
                            choosen=true;
                        incx=0;
                        incy=-1;
                        break;
                    case 2: // DIREITA
                        if(initx + ship.Size() < width)
                            choosen=true;
                        incx=1;
                        incy=0;
                        break;
                    case 3: // BAIXO
                        if(inity + ship.Size() < height)
                            choosen=true;
                        incx=0;
                        incy=1;
                        break;
                    case 4: // ESQUERDA CIMA
                        if((initx - ship.Size() >= 0 && inity-ship.Size()>=0))
                            choosen=true;
                        incx=-1;
                        incy=-1;
                        break;
                    case 5: // DIREITA CIMA
                        if(initx + ship.Size() <width-1 && inity-ship.Size()>=0)
                            choosen=true;
                        incx=1;
                        incy=-1;
                        break;
                    case 6: // DIREITA BAIXO
                        if(initx + ship.Size() <width-1 && inity+ship.Size()<height-1)
                            choosen=true;
                        incx=1;
                        incy=1;
                        break;
                    case 7: // ESQUEDA BAIXO
                        if(initx - ship.Size() >= 0 && inity+ship.Size()<height-1)
                            choosen=true;
                        incx=-1;
                        incy=1;
                        break;
                    default:
                        System.err.println("ERRO");
                }
                
                if(choosen==true)
                    if(checkBoatOccupation(initx, inity,incx, incy, ship))
                        choosen=false;
            }
            
            

            // ESTE CICLO JÁ TRATA DE TODAS AS ADIÇÕES
            for(int x=0; x<ship.Size(); x++){
                fillPos(initx+(x*incx), inity+(x*incy),ship);
            }

		}
    }

    // VERIFICA SE EXISTE ALGUM BARCO NAS POISÇÕES ONDE É SUPOSTO ADICIONAR O BARCO
    public boolean checkBoatOccupation(int initx, int inity, int incx, int incy, Ship ship){
        int counter=0;
        for(int x=0; x<ship.Size(); x++){
        	
        	if(tabuleiro[initx+(x*incx)][inity+(x*incy)]!=0)
                counter++;
        }
        return (counter>0) ? true : false;
    }
    
    public int[][] tabuleirinho(){
    	return tabuleiro;
    }
}