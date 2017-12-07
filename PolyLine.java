import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
/**
 * @file PolyLine.java
 * @author Liam Rossiter
 */
public class PolyLine {
   private List<Integer> xList;  // List of x-coord
   private List<Integer> yList;  // List of y-coord
   private Color m_colour;
 
   /**
    * @param colour colour that the line is being drawn in
    */
   public PolyLine(Color colour) {
      xList = new ArrayList<Integer>();
      yList = new ArrayList<Integer>();
      m_colour = colour;
   }
 
   /**
    * @return the lines colour
    */
   public Color getColour(){
	   return m_colour;
   }
   
   /**
    * @param x integer of the x coordinate of the line
    * @param y integer of the y coordinate of the line
    */
   public void addPoint(int x, int y) {
      xList.add(x);
      yList.add(y);
   }
 
   /**
    * Draws its self 
    * @param g the graphics object the line is being drawn to
    */
   public void draw(Graphics g) { // draw itself
      for (int i = 0; i < xList.size() - 1; ++i) {
         g.drawLine((int)xList.get(i), (int)yList.get(i), (int)xList.get(i + 1),
               (int)yList.get(i + 1));
      }
   }
   
   /**
    * Return the information about the line
    */
   public String toString(){
	   String outString = "";
	   for (int x: xList){
		   outString += String.valueOf(x) + ",";
	   }
	   outString += ";";
	   for (int y: yList){
		   outString += String.valueOf(y) + ",";
	   }
	   return outString;
   }
}