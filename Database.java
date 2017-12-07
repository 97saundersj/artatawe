import java.util.Scanner;

import java.io.File;

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
	/**
	 * saves every object, one at a time, after ordering them according to ids, desc. 
	 */
	public void save() {
		
		

	}
	/**
	 * loads all of the data from the storage file, and loads it into runtime memory
	 */
	public void load() {
		String bidPath = "bids.txt";
		File bids = new File(bidPath);
		
		String profilePath = "profile.txt";
		File profiles = new File(profilePath);
		
		String artworkPath = "artwork.txt";
		File artwork = new File(artworkPath);
		
		try {
			//iteratively create the objects in order
			Scanner scan = new Scanner(bids);
		}catch(Exception e) {
			//files not found
		}
	}
}
