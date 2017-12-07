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
		
		/*
		 * .write(name0
		 * .write(lastName)
		 * 
		 * .write(favourites.size());
		 * for(int i = 0; favourites.size()) {
		 * 	write(favourites.get(i).getUsername());
		 * }
		 */
		
		/* ArrayList<String[]> favouritesNameAll;
		 * while(nextLine) {
		 * 	String name
		 * String lastname = 
		 * int favouritesNumber
		 * favouritesNameAll.get(i) = new String[favouritesNumber];
		 * for(int i = 0; i < favouritesNumber; i++) {
		 * 		favouritesNameAll.get(i)[i] = scan.next();
		 * }
		 * 
		 * for(int a = 0; a < favouritesNameAll.size(); a++) {
		 * 	for(int b = 0; b < favouritesNameAll.get(a).length; b++) {
		 *   profiles.get(a).addFavourite(searchProfiles(favouritesNameAll.get(a)[b]));
		 *  }
		 * }
		 * 
		 * 
		 */
		

	}
	/**
	 * loads all of the data from the storage file, and loads it into runtime memory
	 */
	public void load() {
	
		String profilePath = "profile.txt";
		File profiles = new File(profilePath);
		
		String artworkPath = "artwork.txt";
		File artwork = new File(artworkPath);
		
		String bidPath = "bids.txt";
		File bids = new File(bidPath);
		
		try {
			//iteratively create the objects in order
			//
			Scanner scan = new Scanner(bids);
		}catch(Exception e) {
			//files not found
		}
	}
}
