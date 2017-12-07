import java.time.LocalDateTime;



/**
 * A class to store information about one bid made
 * by a profile on an artwork
 * @author Alex, Ziggy
 */
class Bid {
	private static int idList;
	private final int id;
    private Profile bidder;
    private Artwork art;
    private int price;
    private LocalDateTime bidStart;
    //whether or not the bid is currently active, 
    //ie, whether the bid is on an active artwork, one that has not been
    //sold yet
    
    /**
     * Creates a new bid
     * @param bidder a refrence to a profile object, which profile has set the bid
     * @param art a reference to an artwork object, which artwork this bid is on
     * @param price the amount placed on this artwork
     * @param bidStart the date and time of the start of the bid
     */
    Bid(Profile bidder, Artwork art, int price, LocalDateTime bidStart) {
		idList ++;
		id = idList;
		
    	this.bidder = bidder;
    	this.price = price;
    	this.bidStart = bidStart;
    	this.art = art;
    }

    /**
     * Return the bidder of the bid, a profile object
     * @return the profile object of the bidder who set the bid
     */
	public Profile getBidder() {
		return bidder;
	}

    /**
     * Returns the amount, an integer, of money is placed on this bid
     * @return int, the amount placed on the bid
     */
	public int getPrice() {
		return price;
	}

    /**
     * Returns the date and time, in a LocalDateTime object, of when
     * the bid was placed
     * @return a LocalDateTime of when the bid was first set
     */
	public LocalDateTime getBidStart() {
		return bidStart;
	}
    
	/**
	 * returns the id of the class
	 * @return id 
	 */
	public int getId() {
		return id;
	}
	/**
	 * set the artwork the bid is placed on
	 */
	public void setArt(Artwork a) {
		this.art = a;
	}
	/**
	 * get the artwork the bid is placed on
	 */
	public Artwork getArt() {
		return art;
	}
}
