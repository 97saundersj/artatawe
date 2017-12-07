import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to store and manipulate the storage of artworks
 * 
 * @author Dan,Alex
 */
public class ArtworkManagement {
	private static final String fileName = "src/Data/Artwork.txt";
	private ArrayList<Artwork> artworks;
	private ArrayList<Integer> currentBids = new ArrayList<Integer>();
	private ArrayList<String> creators = new ArrayList<String>();
	/**
	 * Creates a new ArtworkManagement object There should only be one instance
	 * of this class, in database
	 */
	ArtworkManagement() {
		artworks = new ArrayList<Artwork>();
	}

	/**
	 * A method to return an array of bids from an araylist of bids used
	 * internally
	 * 
	 * @param arrayList
	 *            the array list of bids
	 * @return a bid array containing the same elements as the array list
	 */
	private Artwork[] convertToArray(ArrayList<Artwork> arrayList) {
		Artwork[] array = new Artwork[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		return array;
	}
	/**
	 * gets an artwork by title
	 * 
	 */
	public Artwork getArtworkByID(int id) {
		for(int i = 0; i < artworks.size(); i++) {
			if(artworks.get(i).getId() == id) {
				return artworks.get(i);
			}
		}
		return null;
	}
	/**
	 * returns all of the artworks currently in the system
	 * 
	 * @return artworks array, an array of every artwork object registered
	 */
	public ArrayList<Artwork> getAllArtworks() {
		return artworks;
	}

	/**
	 * Adds a new bid to the system
	 * 
	 * @param title
	 *            the title of the painting
	 * @param description
	 *            description of the painting
	 * @param mainPhoto
	 *            an image of the painting
	 * @param creator
	 *            the profile that has put the painting up for auction
	 * @param yearOfCreation
	 *            LocalDateTime when the painting was added to the system
	 * @param reservePrice
	 *            the reserve price under which no successful bid can be made
	 * @param noOfBids
	 *            maximum amount of permitted bids before the painting is sold
	 * @param width
	 *            the width of the painting
	 * @param height
	 *            the height of the painting
	 */
	public void addPainting(String title, String description, Image mainPhoto, Profile creator, int yearOfCreation,
			int reservePrice, int noOfBids, int width, int height) {
		Artwork painting = new Artwork(title, description, mainPhoto, creator, yearOfCreation, reservePrice, noOfBids,
				width, height);
		artworks.add(painting);
	}

	/**
	 * Adds a new bid to the system
	 * 
	 * @param title
	 *            the title of the sculpture
	 * @param description
	 *            description of the sculpture
	 * @param mainPhoto
	 *            an image of the sculpture
	 * @param creator
	 *            the profile that has put the sculpture up for auction
	 * @param yearOfCreation
	 *            LocalDateTime when the sculpture was added to the system
	 * @param reservePrice
	 *            the reserve price under which no successful bid can be made
	 * @param noOfBids
	 *            maximum amount of permitted bids before the sculpture is sold
	 * @param width
	 *            the width of the sculpture
	 * @param height
	 *            the height of the sculpture
	 * @param material
	 *            the material the sculpture is made from
	 */
	public void addSculpture(String title, String description, Image mainPhoto, Profile creator, int yearOfCreation,
			int reservePrice, int noOfBids, int width, int height, int depth, String material) {
		Sculpture sculpture = new Sculpture(title, description, mainPhoto, creator, yearOfCreation, reservePrice,
				noOfBids, width, height, depth, material);
		artworks.add(sculpture);
	}

	/**
	 * returns all of the artworks that a profile has put on to the system
	 * 
	 * @param profile
	 *            the profile whose artworks are to be found
	 * @return an artwork array of all of the artworks that the profile has
	 *         listed
	 */
	public Artwork[] getArtworkByProfile(Profile profile) {
		ArrayList<Artwork> temp = new ArrayList<Artwork>();
		for (int i = 0; i < artworks.size(); i++) {
			if (artworks.get(i).getCreator() == profile) {
				temp.add(artworks.get(i));
			}
		}
		return convertToArray(temp);
	}

	/**
	 * returns all of the artworks that have those characters in the title
	 * 
	 * @param title
	 *            the title of the artworks to be found
	 * @return an artwork array of all of the artworks that have those
	 *         characters in the title
	 */
	public Artwork[] getArtworkByTitle(String title) {
		ArrayList<Artwork> temp = new ArrayList<Artwork>();
		title.toLowerCase();
		// it is now case insensitive
		for (int i = 0; i < artworks.size(); i++) {
			// it will look for partial matches too
			if (artworks.get(i).getTitle().toLowerCase().contains(title)) {
				temp.add(artworks.get(i));
			}
		}
		return convertToArray(temp);
	}

	public void save() {
		File file = new File(fileName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			for (int i = 0; i < artworks.size(); i++) {
				String line = "";
				line += (artworks.get(i).getTitle()) + ",";
				line += (artworks.get(i).getCreator().getUserName()) + ",";
				line += (artworks.get(i).getNoOfBids()) + ",";
				line += (artworks.get(i).getYearOfCreation()) + ",";
				line += (artworks.get(i).getReservePrice()) + ",";
				line += (artworks.get(i).getWidth()) + ",";
				line += (artworks.get(i).getHeight()) + ",";
				if (artworks.get(i).getCurrentBid() !=null){
					line += (artworks.get(i).getCurrentBid().getId()) + ",";
				}
				else{
					line += ",";
				}
				line += (artworks.get(i).getDescription()) + ",";
				line += (artworks.get(i).getType()) + ",";
				if(artworks.get(i).getType().equals("Sculpture")){
					line += (((Sculpture) artworks.get(i)).getMaterial()) + ",";
					line += (((Sculpture) artworks.get(i)).getDepth()) + ",";
				}
				fileWriter.write(line);
				fileWriter.write("\n");
			}
			fileWriter.close();
		} catch (Exception e) {
			// file io error
			e.printStackTrace();
		}
	}

	/**
	 * loads every profile to the text file listed
	 */
	public void load() {
		File file = new File(fileName);
		try {
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNext()) {
				String line = fileReader.nextLine();
				String[] data = line.split(",");
				String title = data[0];
				String username = data[1];
				creators.add(username);
				String noOfBids = data[2];
				String yearOfCreation = data[3];
				String reservePrice = data[4];
				String width = data[5];
				String height = data[6]; 
				String bidID = data[7];
				if (!bidID.equals("")){
					currentBids.add(Integer.parseInt(bidID));
				}
				else{
					currentBids.add(-1);
				}
				String description = data[8]; 
				if (data[9].equals("Sculpture")){
					String material = data[10];
					String depth = data[11];
				}
				
				artworks.add(new Artwork(title, description, null, null, 
						Integer.parseInt(yearOfCreation), Integer.parseInt(reservePrice), 
						Integer.parseInt(noOfBids), Integer.parseInt(width), Integer.parseInt(height)
						));
			}
			fileReader.close();
		} catch (Exception e) {
			// file io error
			e.printStackTrace();
		}
		

	}
	public void loadReferences(BidManagement bidManagement, ProfileManagement profileManagement) {
		for(int i = 0; i < artworks.size(); i++) {
			if (currentBids.get(i) != -1){
				artworks.get(i).setCurrentBid(bidManagement.searchByID(currentBids.get(i)));
			}
			artworks.get(i).setCreator(profileManagement.searchProfile(creators.get(i)));
		}
	}
}
