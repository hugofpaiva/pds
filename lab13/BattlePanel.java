package lab13;

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

		JSONArray ships = (JSONArray) ((JSONObject) board.get("ships")).get("ship");

		for (JSONObject ship : ships) {
			int orientation = (int) (4 * Math.random());
			int initx = (int) (collumns + 1 * Math.random());
			int inity = (int) (rows + 1 * Math.random());

			switch (orientation) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.err.println("ERRO");
			}

		}
		// x = 0;
		// y = 5;
		repaint(); // invoke paintComponent to output the Battle

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int j = 0; j < sizex; j++)
			for (int i = 0; i < sizey; i++) {
				if (battle[i][j] == 0)
					g.setColor(Color.white);
				else if (battle[i][j] == 1) {
					g.setColor(Color.black);
				} else if (battle[i][j] == 2)
					g.setColor(Color.red);
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