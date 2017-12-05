import java.util.ArrayList;

/**
 * 
 * @author Liam Rossiter
 * @date 31/10/2017
 * @class CollaborativeDrawingMessage
 * @brief A message subclass which stores all information needed to store a Collaborative drawing to file 
 */
public class CollaborativeDrawingMessage extends Message {
	/**An ArrayList which stores all PolyLine objects in the drawing */
	private ArrayList<PolyLine> m_lines;
	/**An ArrayList which stores all LineElement objects in the drawing */
	private ArrayList<LineElement> m_sLines;
	/**An ArrayList which stores all TraceElement objects in the drawing */
	private ArrayList<TraceElement> m_tLines;
	
	/**
	 * The constructor which calls the message constructor and sets the contents of the ArrayLists
	 * @param recipients the UserAccounts which will recieve this message
	 * @param sender the UserAccount which created this message
	 * @param conversation the Conversations this message is a part of 
	 * @param type the type of message this is as a String
	 * @param lines the list of PolyLine objects in the drawing
	 * @param sLines the list of LineElement objects in the drawing
	 * @param tLines the list of TraceElement objects in the drawing
	 */
	public CollaborativeDrawingMessage(ArrayList<UserAccount> recipients, UserAccount sender, Conversation conversation,
			String type, ArrayList<PolyLine> lines, ArrayList<LineElement> sLines, ArrayList<TraceElement> tLines) {
		super(recipients, sender, conversation, type);
		m_lines = lines;
		m_sLines = sLines;
		m_tLines = tLines;
	}
	
	/**
	 * The get method for the m_lines attribute
	 * @return the ArrayList containing all PolyLines in the drawing
	 */
	public ArrayList<PolyLine> getLines(){
		return m_lines;
	}
	
	/**
	 * The get method for the m_slines attribute
	 * @return the ArrayList containing all LineElements in the drawing
	 */
	public ArrayList<LineElement> getSLines(){
		return m_sLines;
	}
	
	/**
	 * The get message for the m_tLines attribute
	 * @return the ArrayList containing all TraceElements in the drawing
	 */
	public ArrayList<TraceElement> getTLines(){
		return m_tLines;
	}
	
	/**
	 * Saves the message to memory and calls the Messgage classes sendMessage method on this object
	 */
	public void sendMessage(){
		FileWriter.writeCollabDrawing(this);
		super.sendMessage();
	}

}
