import java.util.ArrayList;
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and container
 
/**
 * 
 * @author Liam Rossiter
 * @date 31/10/2017
 * @class DrawingEnvironment
 * @brief A subclass of JFrame which holds a canvas and some buttons allowing you to choose how you draw to the canvas 
 */
public class DrawingEnvironment extends JFrame {
	
	private static final long serialVersionUID = 1L;
   /**A constant declaring the width of the window */
   public static final int CANVAS_WIDTH = 850;
   /**A constant declaring the height of the window */
   public static final int CANVAS_HEIGHT = 500;
   /**An attribute which defines what colour the drawn lines will be*/
   public static Color m_lineColour = Color.BLACK;
   /**An attribute which defines the colout of the canvas */
   public static Color m_canvasColour = Color.WHITE;
   /**An attribute defining which tool is being used (0-Freehand,1-StraightLine,2-Trace) */
   public static int m_lineType = 0;
 
   /**An arraylist storing all PolyLine objects which will be drawn to screen */
   public static ArrayList<PolyLine> m_lines;
   /**An arraylist storing all LineElement objects which will be drawn to screen */
   public static ArrayList<LineElement> m_sLines;
   /**An arraylist storing all TraceElement objects which will be drawn to screen */
   public static ArrayList<TraceElement> m_tLines;
   /**A PolyLine object which stores the PolyLine currently being drawn */
   private PolyLine m_currentPolyLine;
   /**A LineElement object which stores the LineElement currently being drawn */
   private LineElement m_currentStraightLine;
   /**A TraceElement object which stores the TraceElement currently being drawn */
   private TraceElement m_currentTraceLine;
   /**An ArrayList which stores all UserAccounts  */
   private ArrayList<UserAccount> m_recipients;
   /**The UserAccount which is drawing on the pane */
   private UserAccount m_sender;
   /**The conversation which the drawing will be a part of*/
   private Conversation m_conversation;
   
   /**
    * The get method for the m_lines attribute
    * @return An ArrayList of all PolyLines which have been drawn
    */
   public ArrayList<PolyLine> getLines(){
	   return m_lines;
   }
   
   /**
    * The get method for the m_sLines attributes
    * @return An ArrayList of all LineElements which have been drawn
    */
   public ArrayList<LineElement> getSLines(){
	   return m_sLines;
   }
   
   /**
    * The get method for the m_tLines attribute
    * @return An ArrayList of all TraceElements which have been drawn
    */
   public ArrayList<TraceElement> getTLines(){
	   return m_tLines;
   }
   
   /**
    * The get method for the m_recipients attribute
    * @return the ArrayList storing all UserAccounts the image will be sent to 
    */
   public ArrayList<UserAccount> getRecipients(){
	   return m_recipients;
   }
   
   /**
    * The get method for the m_sender attribute
    * @return the UserAccount which drew the image
    */
   public UserAccount getSender(){
	   return m_sender;
   }
   
   /**
    * The get method for the m_conversation attribute
    * @return the Conversation the image will be a part of
    */
   public Conversation getConversation(){
	   return m_conversation;
   }
   
   
   /**
    * 
    * @param recipients An ArrayList storing all UserAccounts the drawing message will be sent to
    * @param sender
    * @param conversation
    */
   public DrawingEnvironment(ArrayList<UserAccount> recipients,UserAccount sender,Conversation conversation) { 
	    UserAccount user1 = new UserAccount("Pussyman5000", "Joe", "Rapley","+447786606269", 13, 10, 1996, "Wickford");
		UserAccount user2 = new UserAccount("1234", "Barry", "Benson", "+448888888888", 8, 8, 1888, "The Hive");
		UserAccount user3 = new UserAccount("8888","Harambe", "TheGorilla", "+15132814700", 27, 5, 1999, "Heaven");
		ArrayList<UserAccount> recipientTest = new ArrayList<>();
		Conversation conv1 = new Conversation();
		recipientTest.add(user1);
		recipientTest.add(user2);
		conv1.addParticipant(user1);
		conv1.addParticipant(user2);
		conv1.addParticipant(user3);
	  m_recipients = recipientTest;
	  m_sender = user3;
	  m_conversation = conv1;
	  m_lines = new ArrayList<PolyLine>(); 
	  m_sLines = new ArrayList<LineElement>();
	  m_tLines = new ArrayList<TraceElement>();
      JPanel buttonPanel = new JPanel();     
      buttonPanel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT+40));
      
      DrawingScreen canvas = new DrawingScreen();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));     
      canvas.setBackground(Color.WHITE);
      buttonPanel.add(canvas);
      
      JButton straightButton = new JButton("Straight Line Tool");
      straightButton.setBounds(10, 10, 100, 50);
      straightButton.setBackground(Color.BLACK);
      straightButton.setForeground(Color.WHITE);
      straightButton.setFocusable(false);
      straightButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  m_lineType = 1;
    	  }
      });
      buttonPanel.add(straightButton);
      
      JButton freehandButton = new JButton("Freehand Tool");
      freehandButton.setBounds(10, 10, 100, 50);
      freehandButton.setBackground(Color.BLACK);
      freehandButton.setForeground(Color.WHITE);
      freehandButton.setFocusable(false);
      freehandButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  m_lineType = 0;
    	  }
      });
      buttonPanel.add(freehandButton);
      
      JButton traceButton = new JButton("Trace Tool");
      traceButton.setBounds(10, 10, 100, 50);
      traceButton.setBackground(Color.BLACK);
      traceButton.setForeground(Color.WHITE);
      traceButton.setFocusable(false);
      traceButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  m_lineType = 2;
    	  }
      });
      buttonPanel.add(traceButton);
      
      JButton colourButton = new JButton("Change Colour");
      colourButton.setBounds(10, 10, 100, 50);
      colourButton.setBackground(Color.BLACK);
      colourButton.setForeground(Color.WHITE);
      colourButton.setFocusable(false);
      colourButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  m_lineColour = JColorChooser.showDialog(DrawingEnvironment.this,
                      "Choose a color",m_lineColour);
    		  colourButton.setBackground(m_lineColour);
    		  colourButton.setForeground(Color.WHITE);
    		  if (m_lineColour.equals(Color.WHITE)){
    			  colourButton.setForeground(Color.BLACK);
    		  }
    	  }
      });
      buttonPanel.add(colourButton);
      
      JButton canvasButton = new JButton("Change Canvas Colour");
      canvasButton.setBounds(10, 10, 100, 50);
      canvasButton.setBackground(Color.BLACK);
      canvasButton.setForeground(Color.WHITE);
      canvasButton.setFocusable(false);
      canvasButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  m_canvasColour = JColorChooser.showDialog(DrawingEnvironment.this,
                      "Choose a color",m_canvasColour);
    		  canvasButton.setBackground(m_canvasColour);
    		  canvas.setBackground(m_canvasColour);
    		  canvasButton.setForeground(Color.WHITE);
    		  if (m_canvasColour.equals(Color.WHITE)){
    			  canvasButton.setForeground(Color.BLACK);
    		  }
    	  }
      });
      buttonPanel.add(canvasButton);
      
      JButton saveButton = new JButton("Save");
      saveButton.setBounds(10, 10, 100, 50);
      saveButton.setBackground(Color.BLACK);
      saveButton.setForeground(Color.WHITE);
      saveButton.setFocusable(false);
      saveButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  CollaborativeDrawingMessage collabMessage = new CollaborativeDrawingMessage(m_recipients, m_sender, m_conversation, "COLLAB", 
    				  m_lines, m_sLines, m_tLines);
    		  collabMessage.sendMessage();
    	  }
      });
      buttonPanel.add(saveButton);
      
      JButton openButton = new JButton("Open");
      openButton.setBounds(10, 10, 100, 50);
      openButton.setBackground(Color.BLACK);
      openButton.setForeground(Color.WHITE);
      openButton.setFocusable(false);
      openButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  CollaborativeDrawingMessage c = FileReader.readCollabDrawing("0", user1, conv1);
    		  m_lines = c.getLines();
    		  m_sLines = c.getSLines();
    		  m_tLines = c.getTLines();
    		  repaint();
    	  }
      });
      buttonPanel.add(openButton);
      
      
      canvas.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent evt) {
            // Begin a new line
        	 if (m_lineType == 0){
        		 m_currentPolyLine = new PolyLine(m_lineColour);
        		 m_lines.add(m_currentPolyLine);
        		 m_currentPolyLine.addPoint(evt.getX(), evt.getY());
        	 }else if (m_lineType == 1){
        		 m_currentStraightLine = new LineElement(m_lineColour);
        		 m_sLines.add(m_currentStraightLine);
        		 m_currentStraightLine.setStart(evt.getX(), evt.getY());       		 
        	 }else if (m_lineType == 2){
        		 m_currentTraceLine = new TraceElement(m_lineColour);
        		 m_tLines.add(m_currentTraceLine);
        		 m_currentTraceLine.addPoint(evt.getX(),evt.getY());
        	 }
         }
      });
      canvas.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseReleased(MouseEvent evt) {
             // Begin a new line
         	 if (m_lineType == 1){
         		 m_currentStraightLine.setEnd(evt.getX(), evt.getY());       		 
         	 }
          }
       });
      canvas.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent evt) {
        	if (m_lineType == 0){
	            m_currentPolyLine.addPoint(evt.getX(), evt.getY());
	            repaint();  // invoke paintComponent()
        	}else if (m_lineType == 1){
        		m_currentStraightLine.setEnd(evt.getX(), evt.getY());
        		repaint();
        	}else if (m_lineType == 2){
        		m_currentTraceLine.addPoint(evt.getX(), evt.getY());
        		repaint();
        	}
         }
      });
 
      setContentPane(buttonPanel);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setTitle("Collaborative Drawing Environment");
      pack();
      setResizable(false);
      setVisible(true);
   }
   
   public static class DrawingScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	@Override
	   protected void paintComponent(Graphics g) { // called back via repaint()
		   super.paintComponent(g);
		   for (PolyLine line:m_lines) {
			   g.setColor(line.getColour());
			   line.draw(g);
		   }
		   for (LineElement sline: m_sLines){
			   g.setColor(sline.getColour());
			   sline.draw(g);
		   } 
		   for (TraceElement tline: m_tLines){
			   g.setColor(tline.getColour());
			   tline.draw(g);
		   }
		   
	      
	   }
	}
}

