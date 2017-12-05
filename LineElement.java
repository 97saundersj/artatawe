/**
 * @file    -LineElement.java
 * @author  -Liam Rossiter
 * @date    -31/10/2017
 *
 * A class to draw a line between two individual points.
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class LineElement {
	   private Point start; 
	   private Point end; 
	   private Color m_colour;
	   
	 
	   /**
	    * LineElement has the information to contruct a line using 
		* it's start point (x,y), end point (x,y)and it's colour. 
		* @param colour
		*/
	   public LineElement(Color colour) {
	      start = new Point();
	      end = new Point();
	      m_colour = colour;
	   }
	   
	   /**
	    * getColour() returns the colour of a line.
		* @return m_colour
		*/
	   public Color getColour(){
		   return m_colour;
	   }
	 
	   /**
	    * setStart sets the start point of a line using it's x and y co-ordinates
		* @param x
		* @param y
		*/
	   public void setStart(int x, int y) {
	      start.setLocation(x, y);
	      
	   }
	   
	   /**
	    * setEnd sets the end point of a line using it's x and y co-ordinates
		* @param x
		* @param y
		*/
	   public void setEnd(int x, int y){
		   end.setLocation(x, y);
	   }
	 
	   /** 
	    * draw takes in the graphics (x and y co-ordinates) of a line and draws it on the canvas
		* @param g
		*/
	   public void draw(Graphics g) { // draw itself
		   g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
	   }
	   
	   /**
	    * toString() returns the co-ordinates of a line as a string.
		* @return outString
		*/
	   public String toString(){
		   String outString = "";
		   outString += start.getX() + "," + start.getY()+ "," + end.getX() + "," + end.getY();
		   return outString; 
	   }
	}
