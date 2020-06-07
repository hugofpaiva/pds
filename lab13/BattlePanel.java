package LAB13;

import java.awt.*;

import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BattlePanel extends JPanel {
	private int[][] battle = new int[25][25];

	private int sizex, sizey, x, y;

	public BattlePanel(JSONObject config) {

		JSONObject board = (JSONObject) config.get("board");
		int rows = Integer.parseInt((String) board.get("rows"));
		int collumns = Integer.parseInt((String) board.get("collumns"));
		Board tabuleiro = new Board(collumns, rows);

		if (collumns > 0 && collumns <= 25) {
			sizex = collumns;
		} else {
			sizex = 25;
		}

		if (rows > 0 && rows <= 25) {
			sizey = rows;
		} else {
			sizey = 25;
		}

		JSONArray ships = (JSONArray) ((JSONObject) config.get("ships")).get("ship");

		for (int i=1; i <= ships.size(); i++) {
			JSONObject temp = (JSONObject) ships.get(i-1);
			Ship s=new Ship(i,  temp.get("name").toString(), Integer.valueOf(temp.get("size").toString()));
			tabuleiro.addShip(s);
		}
		
		tabuleiro.fillBoard();
		battle=tabuleiro.tabuleirinho();
		repaint(); // invoke paintComponent to output the Battle

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int j = 0; j < sizex; j++)
			for (int i = 0; i < sizey; i++) {
				if (battle[i][j] == 0)
					g.setColor(Color.white);
				else if (battle[i][j] == 1) 
					g.setColor(Color.black);
				else if (battle[i][j] == 2)
					g.setColor(Color.red);
				else if (battle[i][j] == 3)
					g.setColor(Color.green);
				else if (battle[i][j] == 4)
					g.setColor(Color.blue);
				else if (battle[i][j] == 5)
					g.setColor(Color.yellow);
				g.fillRect(i * 20, j * 20, 20, 20);
			}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		repaint();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		repaint();
	}

}
