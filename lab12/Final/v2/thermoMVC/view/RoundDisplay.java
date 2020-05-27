package lab12.v2.thermoMVC.view;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lab12.v2.thermoMVC.model.Thermometer;
import lab12.v2.thermoMVC.model.ThermometerListener;


/**
 * An view of a thermometer that looks like a mercury thermometer
 */
public class RoundDisplay extends JPanel implements ThermometerListener {
	/** The height of the mercury tube */
	private static final int TUBE_HEIGHT = 150;

	/** The width of the mercury tube */
	private static final int TUBE_WIDTH = 10;

	/** The left edge of the tube */
	private static final int LEFT = 100;

	/** The top of the tube */
	private static final int TOP = 50;

	/** The height of the component containing the tube */
	private static final int COMPONENT_HEIGHT = TUBE_HEIGHT * 2;

	/** The width of the component containing the tube */
	private static final int COMPONENT_WIDTH = TUBE_WIDTH * 30;
	
	/** The thermometer being displayed */
	private final Thermometer therm;

	/** The temperature on the display */
	protected int displayTemperature;
	
	/** The minimum temperature */
	protected int minimum;

	/** The maximum temperature */
	protected int maximum;
	
	/**
	 * Creates a display
	 * @param t the thermometer being displayed
	 * @param min the minimum temperature the thermometer should display
	 * @param max the maximum temperature the thermometer should display
	 */
	public RoundDisplay(int min, int max, Thermometer t) {
		therm = t;
		minimum = min;
		maximum = max;

		setCurrent(t.getTemperature());
	}

	/**
	 * React to changes to the temperature.
	 */
	@Override
	public void temperatureChanged() {
		setCurrent (therm.getTemperature());
	}

	/**
	 * Displays the temperature passed in.
	 * @param cur the temperature to display.  If cur is outside the range of the thermometer,
	 * the mercury is set at its upper or lower bound.
	 */
	protected void setCurrent(int cur) {
		if (cur > maximum) {
			displayTemperature = maximum;
		}
		else if (cur < minimum) {
			displayTemperature = minimum;
		}
		else {
			displayTemperature = cur;
		}
		repaint();
	}

	/**
	 * Draws the thermometer as a mercury tube and bulb with the minimum,
	 * maximum, and current temperatures labeled.
	 * @param g the graphics context to draw on
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.black);
		
        int angle=(int) Math.floor((-1)*displayTemperature*1.5);
        
        g.fillArc(LEFT, TOP+100, 200, 200, 180, angle);
	}

	/**
	 * Returns the minimum size for the thermometer component
	 * @return the minimum size for the thermometer component
	 */
	@Override
	public Dimension getMinimumSize() {
		return new Dimension (COMPONENT_WIDTH, COMPONENT_HEIGHT);
	}

	/**
	 * Returns the preferred size for the thermometer component
	 * @return the preferred size for the thermometer component
	 */
	@Override
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}	
	
}
