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
	
	public Database() {
		this.bidManagement = new BidManagement();
		this.artworkManagement = new ArtworkManagement();
		this.profileManagement = new ProfileManagement();
	}
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
		//save the profiles
		profileManagement.save();
		artworkManagement.save();
		bidManagement.save();

	}
	/**
	 * loads all of the data from the storage file, and loads it into runtime memory
	 */
	public void load() {
		artworkManagement.load();
		profileManagement.load();
		bidManagement.load();
		
		profileManagement.loadReferences(artworkManagement);
		artworkManagement.loadReferences(bidManagement,profileManagement);
		bidManagement.loadReferences(artworkManagement,profileManagement);
	}
}
