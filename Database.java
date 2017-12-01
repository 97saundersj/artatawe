import java.time.LocalDateTime;

/**
 * **TODO FULLY**
 * A class to store refrences to the management of data classes and provide operations of storing and manipulating data
 * to the rest of the program
 *
 */
public class Database {
	private BidManagement bidManagement;
	//ArtworkManagement artworkManagement;
	//ProfleManagement profileManagement;
	
	public Database() {}
	
	public void addBid(Profile bidder, Artwork art, int price, LocalDateTime bidStart) {
		bidManagement.addBid(bidder, art, price, bidStart);
	}
}
