package LAB13;

import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class Main {
	
    public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		JSONObject config = null;
        try (Reader reader = new FileReader("./src/lab13/config.json");) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            config = (JSONObject) jsonObject.get("configuration");
			
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        JFrame frame = new JFrame();
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BattlePanel mp = new BattlePanel(config);
		frame.add(mp);
		frame.setFocusable(true);
	    frame.requestFocus();
	    //frame.addKeyListener(new KeyHandler(mp));
		frame.setVisible(true);
    }
}