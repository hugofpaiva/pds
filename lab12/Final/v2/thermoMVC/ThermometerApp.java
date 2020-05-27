package lab12.v2.thermoMVC;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab12.v2.thermoMVC.model.Thermometer;
import lab12.v2.thermoMVC.view.DigitalDisplay;
import lab12.v2.thermoMVC.view.RoundDisplay;

/**
 * This class displays a mercury and digital thermometer.  The user can change 
 * the temperature displayed by entering a value in the text field.
 */
public class ThermometerApp {
	/**
	 * The main program creates the user interface for the thermometer
	 * application and creates an initial thermometer.
	 * @param args None expected.
	 */
	public static void main(String[] args) {
		// Create the thermometer.
		int startingTemp = 50;

		final Thermometer thermometer = new Thermometer (startingTemp);
		
		// Create the frame
		JFrame frame = new JFrame ("Thermometer");
		Container mainPanel = frame.getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		// Create the panel where the user can type in a new temperature.
		JPanel valuePanel = new JPanel();
		
		valuePanel.add (new JLabel ("Enter a temperature to display"));
		JTextField tempField = new JTextField (5);
		tempField.addActionListener (new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					int newTemp = Integer.parseInt (((JTextField) event.getSource()).getText());
					thermometer.setCurrent (newTemp);
				} catch (NumberFormatException e) {
					// Ignore anything other than integers
				}
			}
		});
		
		valuePanel.add(tempField);
		mainPanel.add (valuePanel);
		
		JPanel a = new JPanel(); 
		
		DigitalDisplay thermometerDisplay3 = new DigitalDisplay(thermometer);
		RoundDisplay thermometerDisplay2 = new RoundDisplay(-10, 120, thermometer);

		
		// Add the views to the display
		a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
		
		JLabel b = new JLabel("0ºF",
                JLabel.RIGHT);
		a.add(b);
		
		b.setHorizontalTextPosition(JLabel.CENTER);
		
		a.add(thermometerDisplay2);
		
		a.add(new JLabel("120ºF",
                JLabel.CENTER));

		a.setAlignmentX(thermometerDisplay2.BOTTOM_ALIGNMENT);
		a.setAlignmentY(thermometerDisplay2.BOTTOM_ALIGNMENT);
		
		mainPanel.add(a);
		
		mainPanel.add(thermometerDisplay3);
		
		
		
		// Get the views to listen to the model

		thermometer.addThermometerListener(thermometerDisplay2);
		thermometer.addThermometerListener(thermometerDisplay3);

		// Display the frame
		frame.pack();
		frame.setVisible (true);
	}
	
}
