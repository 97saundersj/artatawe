import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
/**
 * @file TraceElement.java
 * @author Liam Rossiter
 */
public class TraceElement {
	private ArrayList<Point> m_points;
	private Color m_colour;
	private final int OVAL_WIDTH = 4;
	private final int OVAL_HEIGHT = 4;
	
	/**
	 * @param colour the colour of the trace being drawn
	 */
	public TraceElement(Color colour){
		m_points = new ArrayList<Point>();
		m_colour = colour;
	}
	
	/**
	 * @param x integer of the x position of the trace element
	 * @param y integer of the y position of the trace element
	 */
	public void addPoint(int x, int y){
		m_points.add(new Point(x,y));
	}
	
	/**
	 * @return the colour of the trace element
	 */
	public Color getColour(){
		return m_colour;
	}
	
	/**
	 * @param g the graphics object the trace element is being drawn to
	 */
	public void draw(Graphics g){
		for(Point p: m_points){
			g.fillOval((int)p.getX(), (int)p.getY(), OVAL_WIDTH, OVAL_HEIGHT);
		}
	}
	
	/**
	 * return the points of the trace element separated by commas 
	 */
	public String toString(){
		String outString = "";
		for (Point p: m_points){
			outString += p.getX() + "," + p.getY() + ";";
		}
		return outString;
	}
}
