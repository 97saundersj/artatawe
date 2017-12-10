import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * **TODO FULLY**
 * A class to store refrences to the management of data classes and provide operations of storing and manipulating data
 * to the rest of the program
 *
 */
public class Database {
	private static BidManagement bidManagement;
	private static ArtworkManagement artworkManagement;
	private static ProfileManagement profileManagement;
	private static final String imagePath = "src/Images/";
	
	public Database() {
		this.bidManagement = new BidManagement();
		this.artworkManagement = new ArtworkManagement();
		this.profileManagement = new ProfileManagement();
	}
	/**
	 * This returns the bidmanagement, so the classes can manipulate the bids
	 * @return bidmanagement
	 */
	public static BidManagement manageBids() {
		return bidManagement;
	}
	/** 
	 * This returns the artworkmanagement, so the classes can manipulate the artworks
	 * @return artworkmanagement
	 */
	public static ArtworkManagement manageArtwork() {
		return artworkManagement;
	}
	/** 
	 * This returns the profile management, so the classes can manipulate the profiles
	 * @return profilemanagement
	 */
	public static ProfileManagement manageProfiles() {
		return profileManagement;
	}
	/**
	 * a method to return an arraylist of bufferedimages given an arraylist of filepaths to these image(s)
	 * @param filePaths an arraylist containing filepaths to images
	 * @return an arraylist of bufferedimage objects
	 */
	public static ArrayList<BufferedImage> convertArrayListToImage(ArrayList<String> filePaths) {
		ArrayList<BufferedImage> temp = new ArrayList<BufferedImage>();
		for(int i = 0; i < filePaths.size(); i++) {
			temp.add(convertPathToImage(filePaths.get(i)));
		}
		return temp;
	}
	/**
	 * converts a filepath defined to an image
	 * @param filePath the filepath, as a string to the image
	 * @return the image, in a bufferedimage object
	 */
	public static BufferedImage convertPathToImage(String filePath){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.out.print(e);
		}
		return img;
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
	public static void load() {
		artworkManagement.load();
		profileManagement.load();
		bidManagement.load();
		
		profileManagement.loadReferences(artworkManagement);
		artworkManagement.loadReferences(bidManagement,profileManagement);
		bidManagement.loadReferences(artworkManagement,profileManagement);
	}
}
