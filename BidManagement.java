import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class to store and manipulate the storage of bids
 * @author Ziggy
 *
 */
public class BidManagement {
	private ArrayList<Bid> bids;
	private final String fileName = "src/data/Bids.txt";
	
	/**
	 * Creates a new BidManagement object
	 * There should only be one instance of this class, in database
	 */
	BidManagement() {
		bids = new ArrayList<Bid>();
	}
	/**
	 * Adds a new bid to the system
	 * @param bidder the profile that registered the bid
	 * @param art the art that the bid references
	 * @param price the price that the bid lists 
	 * @param bidStart the time and date of the start of the bid, in LocalDateTime
	 */
	public void addBid(Profile bidder, Artwork art, int price, LocalDateTime bidStart) {
		Bid bid = new Bid(bidder, art, price, bidStart);
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
				art.addBid(bid);
				bids.add(bid);
				if(art.bidAvaliable() == false) {
					bidder.addArtworkWon(art);
				}
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
	public ArrayList<Bid> getAllBids() {
		return bids;
	}
	/**
	 * returns all of the bids that a profile has put on to the sysetm
	 * the bids a profile has registered on artworks
	 * @param profile the profile whose bids are to be found
	 * @return a bid array of all of the bids that the profile has listed
	 */
    public ArrayList<Bid> getBidByProfile(Profile profile) {
        ArrayList<Bid> temp = new ArrayList<Bid>();
        for(int i = 0; i < bids.size(); i++) {
        	if(bids.get(i).getBidder() == profile) {
        		temp.add(bids.get(i));
        	}
        }
        return temp;
		
	}
	/**
	 * returns all of the bids that have been placed on an artwork
	 * @param artwork, the artwork whose bids to find
	 * @return a bid array of all of the bids that the profile has listed
	 */
    public ArrayList<Bid> getBidByArtwork(Artwork artwork) {
        ArrayList<Bid> temp = new ArrayList<Bid>();
        for(int i = 0; i < bids.size(); i++) {
        	if(bids.get(i).getArt() == artwork) {
        		temp.add(bids.get(i));
        	}
        }
        return temp;
		
	}
    public Bid searchByID(int ID){
    	Bid tmp = null;
    	for (int i = 0; i< this.bids.size();i++){
    		if (bids.get(i).getId() == ID){
    			tmp =  bids.get(i);
    		}

    	}
    	return tmp;
    }
    
    public void save() {
		File file = new File(fileName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			for (int i = 0; i < bids.size(); i++) {
				String line = "";
				line += bids.get(i).getBidder().getUserName() +",";
				line += bids.get(i).getArt().getId() +",";
				line += bids.get(i).getPrice() +",";
				line += bids.get(i).getBidder().getUserName() +",";
				fileWriter.write(line);
				fileWriter.write("\n");
			}
			fileWriter.close();
		} catch (Exception e) {
			// file io error
			e.printStackTrace();
		}
	
	
	
}
