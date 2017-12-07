import java.time.LocalDateTime;

/**
 * **TODO FULLY**
 * A class to store refrences to the management of data classes and provide operations of storing and manipulating data
 * to the rest of the program
 *
 */
public class Database {
	private BidManagement bidManagement;
	private ArtworkManagement artworkManagement;
	private ProfileManagement profileManagement;
	
	public Database() {}
	/**
	 * This returns the bidmanagement, so the classes can manipulate the bids
	 * @return bidmanagement
	 */
	public BidManagement manageBids() {
		return bidManagement;
	}
	/** 
	 * This returns the artworkmanagement, so the classes can manipulate the artworks
	 * @return artworkmanagement
	 */
	public ArtworkManagement manageArtwork() {
		return artworkManagement;
	}
	/** 
	 * This returns the profile management, so the classes can manipulate the profiles
	 * @return profilemanagement
	 */
	public ProfileManagement manageProfiles() {
		return profileManagement;
	}
}
