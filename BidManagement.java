import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class to store and manipulate the storage of bids
 * @author Ziggy
 *
 */
public class BidManagement {
	private ArrayList<Bid> bids;
	
	/**
	 * Creates a new BidManagement object
	 * There should only be one instance of this class, in database
	 */
	BidManagement() {
		bids = new ArrayList<Bid>();
	}
	/**
	 * A method to return an array of bids from an araylist of bids
	 * used internally
	 * @param arrayList the array list of bids
	 * @return a bid array containing the same elements as the array list
	 */
	private Bid[] convertToArray(ArrayList<Bid> arrayList) {
		Bid[] array = new Bid[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		return array;
	}
	/**
	 * Adds a new bid to the system
	 * @param bidder the profile that registered the bid
	 * @param art the art that the bid references
	 * @param price the price that the bid lists 
	 * @param bidStart the time and date of the start of the bid, in LocalDateTime
	 */
	public void addBid(Profile bidder, Artwork art, int price, LocalDateTime bidStart) {
		Bid bid = new Bid(bidder, price, bidStart);
		Bid highestBid = art.getCurrentBid();
		boolean accepted = false;
		if(highestBid == null) {
			if(price > art.getReservePrice()) {
				//ACCEPTED: price highest than reserve price and no more variables
				accepted = true;
				
			}
			else {
				//REFUSED: price not as high as reserve price
				accepted = false;
			}
		}
		else {
		    if(highestBid.getBidder() == bidder) {
			    //REFUSED: the highest bidder is the bidder, refused
		    	accepted = false;
		    }
		    else if(price > highestBid.getPrice()) {
			    //ACCEPTED: the price is higher than the highest bid, not the new bidder
			    //and higher than the reserve price
		    	accepted = true;
			
		    }
		}
		if(accepted) {
			if(art.bidAvaliable()) {
				//FINAL ACCEPT
				bids.remove(highestBid);
				art.addBid(bid);
				bids.add(bid);
			}
			else {
				// REFUSE: Bid refused, there is already the allocated bids on the artwork
			}
		}
		
	}
	/**
	 * returns all of the bids currently in the system
	 * @return bid array, an array of every bid object registered
	 */
	public Bid[] getAllBids() {
		return convertToArray(bids);
	}
	/**
	 * returns all of the bids that a profile has put on to the sysetm
	 * the bids a profile has registered on artworks
	 * @param profile the profile whose bids are to be found
	 * @return a bid array of all of the bids that the profile has listed
	 */
    public Bid[] getBidByProfile(Profile profile) {
        ArrayList<Bid> temp = new ArrayList<Bid>();
        for(int i = 0; i < bids.size(); i++) {
        	if(bids.get(i).getBidder() == profile) {
        		temp.add(bids.get(i));
        	}
        }
        return convertToArray(temp);
		
	}
	
	
	
}
